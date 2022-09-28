package rookie.shop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rookie.shop.entity.ItemEntity;

import javax.persistence.EntityManager;
import java.util.List;

//상품 테이블 관련 DB CRUD
//@Repository
//@RequiredArgsConstructor
public class ItemRepository implements ItemRepositoryInterface {

    //private final EntityManager em;
    private EntityManager em;

    //상품 목록
    public List<ItemEntity> findItemAll(){
        return em.createQuery("select item from Item item", ItemEntity.class)
                .getResultList();
    }


    //특정 상품
    public ItemEntity findItem(Long id){
        return em.find(ItemEntity.class,id);
    }


}
