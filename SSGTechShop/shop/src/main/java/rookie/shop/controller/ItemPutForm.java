package rookie.shop.controller;

import lombok.Getter;
import lombok.Setter;
import rookie.shop.TestMember;

@Getter
@Setter
public class ItemPutForm {
    
    private Long item;

    private Long member = TestMember.memberId; //사용자1번으로 고정
    private int quantity;
}
