package rookie.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

//장바구니 테이블의 PK이자 FK
@Getter
@Setter
public class CartId implements Serializable {

    private Long item;

    private Long member;

}
