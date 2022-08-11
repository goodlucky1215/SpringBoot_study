package rookie.shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Data
@Getter
@Setter
public class Cart {

    public Cart() {

    }
    public Cart(Item item, Member member){
        this.item = item;
        this.member = member;
    }
    public Cart(Item item, Member member, int quantity){
        this.item = item;
        this.member = member;
        this.quantity = quantity;
    }

    private Item item;
    private Member member;

    @NumberFormat(pattern = "###,###")
    private int quantity;
}
