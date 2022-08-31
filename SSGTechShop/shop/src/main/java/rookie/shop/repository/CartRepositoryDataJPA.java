package rookie.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rookie.shop.entity.CartEntity;
import rookie.shop.entity.ItemEntity;
import rookie.shop.entity.MemberEntity;

import java.util.List;

public interface CartRepositoryDataJPA extends JpaRepository<CartEntity, Long> {

    //장바구니 목록
    List<CartEntity> findByMember_IdLike(MemberEntity memberEntity);

    //장바구니 상품 삭제
    void deleteByMember_IdAndItem_IdLike(CartEntity cartEntity);

    //특정 장바구니 제품 아이템
    CartEntity findByItem_idAAndMember_IdLike(ItemEntity itemEntity, MemberEntity memberEntity);
}
