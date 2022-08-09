package rookie.shop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rookie.shop.entity.CartEntity;
import rookie.shop.entity.ItemEntity;
import rookie.shop.entity.MemberEntity;

import javax.persistence.EntityManager;
import java.util.List;

//장바구니 테이블 관련 DB CRUD
@Repository
@RequiredArgsConstructor
public class CartRepository {

    private final EntityManager em;

    //장바구니 목록
    public List<CartEntity> findCartAll(MemberEntity memberEntity) {
       return em.createQuery("select c from Cart c where c.member = :member", CartEntity.class)
                .setParameter("member", memberEntity)
                .getResultList();
    }

  /*
    public List<CartEntity> findCartAll(MemberEntity memberEntity) {
        System.out.println(" findCartAll===================== 장바구니 3개까지");
       return em.createQuery("select c from Cart c where c.member = :member order by c.item.id desc", CartEntity.class)
                .setParameter("member", memberEntity)
                .setFirstResult(0)
                .setMaxResults(3)
                .getResultList();
    }
  */
    //장바구니 상품 삭제
    public void cartItemDelete(CartEntity cartEntity) {
        CartEntity cartEntityDelete = findItemCart(cartEntity.getItem(), cartEntity.getMember());
        em.remove(cartEntityDelete);
    }


    //특정 장바구니 제품 아이템
    public CartEntity findItemCart(ItemEntity itemEntity, MemberEntity memberEntity) {
        List<CartEntity> cartEntity =
                em.createQuery("select c from Cart c where c.item = :item and c.member = :member", CartEntity.class)
                .setParameter("item", itemEntity)
                .setParameter("member", memberEntity)
                .getResultList();
        if(cartEntity.isEmpty()) return null;
        else return cartEntity.get(0);
    }
/*
    public CartEntity findItemCart(ItemEntity itemEntity, MemberEntity memberEntity) {
        List<CartEntity> cartEntity =
                em.createQuery("select c from Cart c" +
                        " join fetch c.item i"+
                        " join fetch c.member m"+
                        " where c.item = :item and c.member = :member", CartEntity.class)
                        .setParameter("item", itemEntity)
                        .setParameter("member", memberEntity)
                        .getResultList();
        if(cartEntity.isEmpty()) return null;
        else return cartEntity.get(0);
    }
*/


    //장바구니 상품 저장
    public void cartSave(CartEntity cartEntity) {
        em.persist(em.contains(cartEntity) ? cartEntity : em.merge(cartEntity));
    }

}
