package rookie.shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    private int price;

    private int quantity;

    private String group;
}
