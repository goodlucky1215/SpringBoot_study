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
import rookie.shop.exception.ItemException;
import rookie.shop.repository.CartRepository;
import rookie.shop.repository.ItemRepository;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//상품 화면 관련 서비스 로직
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    private final ModelMapper modelMapper;

    //상품 목록
    public List<Item> findItemAll(){
        List<ItemEntity> itemEntityList = itemRepository.findItemAll();
        List<Item> ItemDtoList = itemEntityList.stream()
                .map(itemEntity -> modelMapper.map(itemEntity, Item.class)).collect(Collectors.toList());
        return ItemDtoList;
    }

    //장바구니 제품 담기
    @Transactional
    public Map cartPut(Item item, Member member, int itemQuantity) {
        ItemEntity itemEntity = itemRepository.findItem(item.getId());
        MemberEntity memberEntity = modelMapper.map(member, MemberEntity.class);

        Item itemDto = modelMapper.map(itemEntity, Item.class);

        //1. 1개 이상 제품 수n개 이하인지 확인
        if(itemQuantity<=0 || itemQuantity> itemDto.getQuantity()){
            return new ResultCommon().resultMap(new ResultMessage().itemGetExceed(itemDto.getName(), itemDto.getQuantity()),false);
        }

        //2. 사용자가 담은 적이 있는지 확인
        CartEntity findCartEntity = cartRepository.findItemCart(itemEntity, memberEntity);

        //3-1. 담은 적 없으면 insert
        if(findCartEntity == null){
            cartRepository.cartSave(new CartEntity(itemEntity, memberEntity,itemQuantity));
            return new ResultCommon().resultMap(ResultMessage.cartItemAdd,true);
        }
        Cart findCartDto = modelMapper.map(findCartEntity, Cart.class);
        //3-2. 담은 적 있으면 update
        //3-2-1. 담은 갯수가 초과하는지 확인
        int itemQuantityAll = itemQuantity+ findCartDto.getQuantity();
        //if(itemQuantityAll> itemDto.getQuantity()) return new ResultCommon().resultMap(new ResultMessage().itemGetExceed(itemDto.getName(), itemDto.getQuantity()),false);
        if(itemQuantityAll> itemDto.getQuantity()) throw new ItemException(new ResultMessage().itemGetExceed(itemDto.getName(), itemDto.getQuantity()));
        findCartEntity.setQuantity(itemQuantityAll);
        return new ResultCommon().resultMap(new ResultMessage().cartItemQuantityAdd(itemQuantityAll),true);
    }


}
