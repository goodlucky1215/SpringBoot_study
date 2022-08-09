package rookie.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rookie.shop.dto.Item;
import rookie.shop.dto.Member;
import rookie.shop.service.ItemService;

import java.util.List;
import java.util.Map;

//제품 화면과 관련된 이벤트
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    //제품 목록 화면
    @GetMapping("/")
    public String mainHome(Model model){
        //throw new RuntimeException();
        List<Item> itemDtoList = itemService.findItemAll();
        model.addAttribute("itemList", itemDtoList);
        return "itemHome";
    }


    //제품 장바구니에 담기
    @PostMapping("/AddItemCart")
    @ResponseBody
    public Map cartPut(ItemPutForm itemPutForm){
        Item itemDto = new Item(itemPutForm.getItem());
        Member memberDto = new Member(itemPutForm.getMember());
        Map<String,Object> result = itemService.cartPut(itemDto, memberDto, itemPutForm.getQuantity());
        return result;
    }

}
