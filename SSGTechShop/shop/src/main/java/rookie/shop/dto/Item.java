package rookie.shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Data
@Getter
@Setter
public class Item {
    public Item() {
    }
    public Item(Long id) {
        this.id = id;
    }
    private Long id;

    private String name;

    @NumberFormat(pattern = "###,###")
    private int price;

    @NumberFormat(pattern = "###,###")
    private int quantity;

    private String group;
}
