package rookie.shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Member {

    public Member() {

    }

    public Member(Long id){
        this.id = id;
    }

    private Long id;

    private String name;
}
