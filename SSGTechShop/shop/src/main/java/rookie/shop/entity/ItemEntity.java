package rookie.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//제품 테이블
@Entity(name = "Item")
@Getter @Setter
public class ItemEntity {

    public ItemEntity() {
    }
    public ItemEntity(Long id) {
        this.id = id;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;

    @Column(name="item_name")
    private String name;

    @Column(name="item_price")
    private int price;

    @Column(name="item_quantity")
    private int quantity;

    @Column(name="item_group")
    private String group;


}
