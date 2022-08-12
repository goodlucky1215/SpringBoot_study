package rookie.shop.controller;

import lombok.Data;
import rookie.shop.TestMember;

import javax.validation.constraints.NotNull;

@Data
public class ItemPutForm {

    @NotNull//(message = "공백은 싫어요~~~~")
    private Long item;

    private Long member = TestMember.memberId; //사용자1번으로 고정

    @NotNull
    private int quantity;
}
