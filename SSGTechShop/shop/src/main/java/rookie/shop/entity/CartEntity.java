package rookie.shop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


//장바구니 테이블
@Entity(name = "Cart")
@IdClass(CartId.class)
@Getter
@Setter
public class CartEntity {

    public CartEntity() {

    }

    public CartEntity(ItemEntity item, MemberEntity member, int quantity){
        this.item = item;
        this.member = member;
        this.quantity = quantity;
    }

    @Id
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private ItemEntity item;

    @Id
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private MemberEntity member;


    @Column(name="cart_quantity")
    private int quantity;
}
