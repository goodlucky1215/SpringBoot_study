package rookie.shop.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rookie.shop.common.ResultCommon;
import rookie.shop.common.ResultMessage;
import rookie.shop.dto.Cart;
import rookie.shop.dto.Item;
import rookie.shop.dto.Member;
import rookie.shop.entity.CartEntity;
import rookie.shop.entity.ItemEntity;
import rookie.shop.entity.MemberEntity;
import rookie.shop.repository.CartRepository;
import rookie.shop.repository.ItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//장바구니 화면 관련 서비스 로직
@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    private final ModelMapper modelMapper;

    //장바구니 목록
    public Map<String,List<Cart>> findCartAll(Long member_id) {
        List<CartEntity> cartEntityList = cartRepository.findCartAll(new MemberEntity(member_id));
        cartEntityList.get(0).getItem().getName();
        return checkItemQuantityAndGroup(cartEntityList);
    }

    //장바구니 목록 그룹 나누고, 제품 수량 체크
    private Map<String,List<Cart>> checkItemQuantityAndGroup(List<CartEntity> cartEntityList) {
        List<Cart> cartDtoList = cartEntityList.stream()
                .map(cartEntity -> modelMapper.map(cartEntity, Cart.class)).collect(Collectors.toList());
        Map<String,List<Cart>> cartGroupMap = new HashMap<>();
        String ssgDelivery = "쓱배송";
        String dawndelivery = "새벽배송";
        String delivery = "택배";
        cartGroupMap.put(ssgDelivery,new ArrayList<>());
        cartGroupMap.put(dawndelivery,new ArrayList<>());
        cartGroupMap.put(delivery,new ArrayList<>());
        for(int i=0;i<cartDtoList.size();i++){
            Item item = cartDtoList.get(i).getItem();
            int itemQuantity = cartDtoList.get(i).getQuantity();
            //만약 남은 수량이 장바구니 수보다 적다면
            if(itemQuantity> item.getQuantity()){
                cartDtoList.get(i).setQuantity(item.getQuantity());
                cartEntityList.get(i).setQuantity(item.getQuantity());
            }
            //만약 품절에서 다시 재고가 생기면 0 => 1로 업데이트
            else if(itemQuantity==0 && item.getQuantity()>0){
                cartDtoList.get(i).setQuantity(1);
                cartEntityList.get(i).setQuantity(1);
            }
            //맞는 그룹에 담기
            String groupName = cartDtoList.get(i).getItem().getGroup();
            if(groupName.equals(ssgDelivery)) cartGroupMap.get(ssgDelivery).add(cartDtoList.get(i));
            else if(groupName.equals(dawndelivery)) cartGroupMap.get(dawndelivery).add(cartDtoList.get(i));
            else if(groupName.equals(delivery)) cartGroupMap.get(delivery).add(cartDtoList.get(i));
        }
        return cartGroupMap;
    }

    //장바구니 수량 변경
    public Map cartItemUpdate(Item item, Member member,int itemQuantity) {
        //MemberEntity memberEntity = modelMapper.map(member, MemberEntity.class);
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(1L);
        //ItemEntity itemEntity = itemRepository.findItem(item.getId());
        //ItemEntity itemEntity = modelMapper.map(item, ItemEntity.class);
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(item.getId());
        CartEntity findCartEntity = cartRepository.findItemCart(itemEntity, memberEntity);
        Cart findCartDto = modelMapper.map(findCartEntity, Cart.class);
        //Item itemDto = modelMapper.map(itemEntity, Item.class);
        Item itemDto = modelMapper.map(findCartEntity.getItem(), Item.class);

        if(itemQuantity<=0 || itemQuantity> itemDto.getQuantity()){
            System.out.println("itemDto.getQuantity() => "+ itemDto.getQuantity());
            return new ResultCommon().resultMap(findCartDto,new ResultMessage().itemGetExceed(itemDto.getName(), itemDto.getQuantity()),false);
        }
        findCartEntity.setQuantity(itemQuantity);// => 영속성에 있어서 이렇게만해도 자동 업데이트가 일어난다.
        findCartDto.setQuantity(itemQuantity);
        return new ResultCommon().resultMap(findCartDto,new ResultMessage().cartItemQuantityChange(itemQuantity),true);
    }

    //장바구니 제품 삭제
    public Map cartItemDelete(List<Cart> cartDtoList) {
        if(cartDtoList.size()<=0) {
            return new ResultCommon().resultMap(ResultMessage.chiceItemConfirm,false);
        }
        for(Cart cartDto : cartDtoList) {
            CartEntity cartEntity = modelMapper.map(cartDto, CartEntity.class);
            cartRepository.cartItemDelete(cartEntity);
        }
        return new ResultCommon().resultMap(ResultMessage.cartItemDelete,true);
    }

}
