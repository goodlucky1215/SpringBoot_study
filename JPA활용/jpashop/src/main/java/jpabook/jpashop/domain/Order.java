package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id") //fk가 이게 됨.
    private Member member;

    @OneToMany(mappedBy = "order") //order라는 것에 의해서 매핍이 된다는 것임.
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="delivery_id") //1대1의 경우 연관관계의 주인은 액세스(조회, 삭제, 수정 등)이 더 많은 곳에 두는게 좋다.
    private Delivery delivery;

    //date도 원래 매핑해줘야했는데 자바8부터는 LocalDateTime사용하면 알아서 hivernate가 매핑을 해준다.
    //주문시간
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]
}
