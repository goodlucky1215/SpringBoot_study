package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    public void 상품주문(){
        //given
        Member member = createMember();
        Book book = createBook("jpa book",1000,20);

        int orderCount = 7;

        //when
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        //then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.ORDER, getOrder.getStatus(),"상품 주문 상태 : ORDER");
        assertEquals(1, getOrder.getOrderItems().size(),"주문한 상품 수");
        assertEquals(1000*orderCount, getOrder.getTotalPrice(),"상품 주문 가격");
        assertEquals(13, book.getStockQuantity(),"상품 남은 수량");
    }

    @Test
    public void 상품주문_재고수량초과(){
        //given
        Member member = createMember();
        Book book = createBook("jpa book",1000,20);

        //when
        int orderCount = 22;

        //then
        assertThrows(NotEnoughStockException.class, ()->{
            orderService.order(member.getId(), book.getId(), orderCount);
        });

    }

    @Test
    public void 주문취소(){
        //given
        Member member = createMember();
        Book book = createBook("jpa book",1000,20);
        int orderCount = 8;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        orderService.cancelOrder(orderId);

        //when
        Order getOrder =  orderRepository.findOne(orderId);

        //then
        assertEquals(OrderStatus.CANCEL,getOrder.getStatus());
        assertEquals(20,book.getStockQuantity(),"주문 취소 후 상품 갯수");
    }


    private Member createMember(){
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","경기","123-123"));
        em.persist(member);
        return member;
    }

    private Book createBook(String bookName, int price,int quantity){
        Book book = new Book();
        book.setName(bookName);
        book.setPrice(price);
        book.setStockQuantity(quantity);
        em.persist(book);
        return book;
    }
}