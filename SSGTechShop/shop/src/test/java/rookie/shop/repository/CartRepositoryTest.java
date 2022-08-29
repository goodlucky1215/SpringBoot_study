package rookie.shop.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rookie.shop.entity.CartEntity;
import rookie.shop.entity.MemberEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Test
    public void 장바구니목록(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(2L);

        List<CartEntity> cartAll = cartRepository.findCartAll(memberEntity);

        assertEquals(cartAll.size(), 0);
    }


}