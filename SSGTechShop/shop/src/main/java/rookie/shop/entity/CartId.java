package rookie.shop.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//장바구니 테이블의 PK이자 FK
@Getter
@Setter
@EqualsAndHashCode
public class CartId implements Serializable {

    private Long item;

    private Long member;

}
