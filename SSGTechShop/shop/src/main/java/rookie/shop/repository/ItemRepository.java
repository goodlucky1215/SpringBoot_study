package rookie.shop.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Repository;
import rookie.shop.entity.ItemEntity;
import rookie.shop.exception.ItemException;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

//상품 테이블 관련 DB CRUD
@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;



    //상품 목록
    public List<ItemEntity> findItemAll(){
        return em.createQuery("select item from Item item", ItemEntity.class)
                .getResultList();
    }


    public List<ItemEntity> findItemAll1(){
        try{
            if(true) throw new DuplicateKeyException("e");
        }catch (DuplicateKeyException e){
            throw new ItemException(e);
        }
        return em.createQuery("select item from Item item", ItemEntity.class)
                .getResultList();
    }

    public List<ItemEntity> findItemAll2(){

        return em.createQuery("select item from Item item", ItemEntity.class)
                .getResultList();
    }

    //특정 상품
    public ItemEntity findItem(Long id){
        return em.find(ItemEntity.class,id);
    }


}
