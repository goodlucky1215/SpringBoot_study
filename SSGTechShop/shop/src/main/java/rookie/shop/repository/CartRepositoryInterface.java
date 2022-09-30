package rookie.shop.repository;

import rookie.shop.entity.CartEntity;
import rookie.shop.entity.ItemEntity;
import rookie.shop.entity.MemberEntity;

import java.util.List;

public interface CartRepositoryInterface {

    public List<CartEntity> findCartAll(MemberEntity memberEntity);

    public void cartItemDelete(CartEntity cartEntity);

    public CartEntity findItemCart(ItemEntity itemEntity, MemberEntity memberEntity);

    public void cartSave(CartEntity cartEntity);
}
