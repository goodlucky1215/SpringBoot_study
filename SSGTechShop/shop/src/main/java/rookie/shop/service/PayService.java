package rookie.shop.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rookie.shop.TestMember;
import rookie.shop.common.ResultCommon;
import rookie.shop.common.ResultMessage;
import rookie.shop.dto.Cart;
import rookie.shop.dto.Item;
import rookie.shop.dto.Member;
import rookie.shop.entity.CartEntity;
import rookie.shop.entity.ItemEntity;
import rookie.shop.entity.MemberEntity;
import rookie.shop.repository.CartRepository;
import rookie.shop.repository.ItemRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//결제 화면 관련 서비스 로직
@Service
@RequiredArgsConstructor
@Transactional
public class PayService {

    private final ItemRepositoryInterface itemRepository;
    private final CartRepository cartRepository;

    private final ModelMapper modelMapper;
    //아이템 목록 => 구매 목록 리스트(바로 구매)
    public Map directItemBuy(Long item_id, int quantity) {
        List<Cart> buyList = cartInfoOne(item_id,quantity);
        Item item = buyList.get(0).getItem();
        Long totalPrice = 0L;
        //제품이 지금도 그 개수 만큼 있는지 확인
        int itemQuantity = quantity;
        if(itemQuantity<=0){
            return new ResultCommon().resultMap(ResultMessage.chiceItemConfirm,false);
        }
        else if(itemQuantity> item.getQuantity()){
            return new ResultCommon().resultMap(new ResultMessage().itemGetExceed(item.getName(), item.getQuantity()),false);
        }
        totalPrice += itemQuantity* item.getPrice();
        return new ResultCommon().resultMap(totalPrice.toString(),true,buyList);
    }


    //장바구니 => 구매 목록 리스트
    public Map cartItemBuy(List<Integer> payItemId){
        List<CartEntity> cartEntityList = cartInfoList(payItemId);
        List<Cart> cartDtoList = cartEntityList.stream()
                .map(cartEntity -> modelMapper.map(cartEntity, Cart.class)).collect(Collectors.toList());
        if(cartDtoList.size()<=0) {
            return new ResultCommon().resultMap(ResultMessage.cartItemEmpty,false);
        }
        Long totalPrice = 0L;
        //제품이 지금도 그 개수 만큼 있는지 확인
        for(int i=0;i<cartDtoList.size();i++){
            CartEntity cartEntity = cartEntityList.get(i);
            Cart cartDto = cartDtoList.get(i);
            Item itemDto = cartDto.getItem();
            int itemQuantity = cartDto.getQuantity();
            if(itemQuantity<=0){
                return new ResultCommon().resultMap(ResultMessage.chiceItemConfirm,false);
            }
            else if(itemQuantity> itemDto.getQuantity()){
                cartEntity.setQuantity(itemDto.getQuantity()); //남은 제품 업데이트
                cartDto.setQuantity(itemDto.getQuantity()); //남은 제품 업데이트
                return new ResultCommon().resultMap(new ResultMessage().itemGetExceed(itemDto.getName(), itemDto.getQuantity()),false);
            }
            totalPrice += cartDto.getQuantity()* itemDto.getPrice();
        }
        return new ResultCommon().resultMap(totalPrice.toString(),true,cartDtoList);
    }

    //결제(바로)
    public Map<String, Object> payItem(Long item_id, Integer quantity) {
        //문제가 없으면 구매 완료
        ItemEntity itemEntity = itemRepository.findItem(item_id);
        Long totalPrice = 0L;
        int itemQuantity = itemEntity.getQuantity()-quantity;
        if(itemQuantity<0) {
            return new ResultCommon().resultMap(new ResultMessage().itemPayExceed(itemEntity.getName(), itemEntity.getQuantity()),false);
        }
        totalPrice += quantity* itemEntity.getPrice();
        itemEntity.setQuantity(itemQuantity); //남은 제품 업데이트
        return new ResultCommon().resultMap(new ResultMessage().resultPayment(totalPrice),true);
    }

    //결제(장바구니)
    public Map payItem(List<Integer> payItemId) {
        List<CartEntity> cartEntityList = cartInfoList(payItemId);
        List<Cart> cartDtoList = cartEntityList.stream()
                .map(cartEntity -> modelMapper.map(cartEntity, Cart.class)).collect(Collectors.toList());
        //문제가 없으면 구매 완료
        Long totalPrice = 0L;
        for(int i=0;i<cartDtoList.size();i++){
            CartEntity cartEntity = cartEntityList.get(i);
            ItemEntity itemEntity = cartEntityList.get(i).getItem();
            Cart cartDto = cartDtoList.get(i);
            Item itemDto = cartDto.getItem();
            int itemQuantity = itemDto.getQuantity()- cartDto.getQuantity();
            if(itemQuantity<0) {
                return new ResultCommon().resultMap(new ResultMessage().itemPayExceed(itemDto.getName(), itemDto.getQuantity()),false);
            }
            totalPrice += cartDto.getQuantity()* itemDto.getPrice();
            itemEntity.setQuantity(itemQuantity); //남은 제품 업데이트
            cartRepository.cartItemDelete(cartEntity); //구매된 제품 삭제
        }
        return new ResultCommon().resultMap(new ResultMessage().resultPayment(totalPrice),true);
    }


    public List<Cart> cartInfoOne(Long itemId, int quantity){
        List<Cart> cartDtoList = new ArrayList<>();
        Member memberDto = new Member(TestMember.memberId);
        ItemEntity itemEntity = itemRepository.findItem(itemId.longValue());
        Item itemDto = modelMapper.map(itemEntity,Item.class);
        cartDtoList.add(new Cart(itemDto, memberDto,quantity));
        return cartDtoList;
    }

    public List<CartEntity> cartInfoList(List<Integer> param){
        List<CartEntity> cartEntityList = new ArrayList<>();
        Member memberDto= new Member(TestMember.memberId);
        MemberEntity memberEntity = modelMapper.map(memberDto,MemberEntity.class);
        for(Integer itemId : param){
            Item itemDto = new Item(itemId.longValue());
            ItemEntity itemEntity = modelMapper.map(itemDto,ItemEntity.class);
            cartEntityList.add(cartRepository.findItemCart(itemEntity, memberEntity));
        }
        return cartEntityList;
    }
}
