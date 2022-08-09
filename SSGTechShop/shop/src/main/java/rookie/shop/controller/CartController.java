package rookie.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import rookie.shop.TestMember;
import rookie.shop.dto.Cart;
import rookie.shop.dto.Item;
import rookie.shop.dto.Member;
import rookie.shop.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//장바구니 화면과 관련된 이벤트
@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    //사용자 장바구니
    @GetMapping("/cart")
    public String cartHome(Model model){
        Map<String, List<Cart>> cartGroupMap = cartService.findCartAll(TestMember.memberId);
        model.addAttribute("ssgdelivery",cartGroupMap.get("쓱배송"));
        model.addAttribute("dawndelivery",cartGroupMap.get("새벽배송"));
        model.addAttribute("delivery",cartGroupMap.get("택배"));
        return "cartHome";
    }

    //사용자 장바구니 제품 개수 변경
    @PostMapping("/cartItemUpdate")
    @ResponseBody
    public Map<String,Object> cartItemUpdate(ItemPutForm itemPutForm){
        Item itemDto = new Item(itemPutForm.getItem());
        Member memberDto = new Member(itemPutForm.getMember());
        Map<String,Object> map = cartService.cartItemUpdate(itemDto, memberDto, itemPutForm.getQuantity());
        return map;
    }

    //장바구니에서 제품 삭제
    @PostMapping("/cartItemDelete")
    @ResponseBody
    public Map<String,Object> cartItemDelete(@RequestBody List<Long> param){
        List<Cart> cartDtoList = cartInfoList(param);
        Map<String,Object> map = cartService.cartItemDelete(cartDtoList);
        return map;
    }


    public List<Cart> cartInfoList(List<Long> param){
        List<Cart> cartDtoList = new ArrayList<>();
        Member memberDto = new Member(TestMember.memberId);
        for(Long itemId : param){
            Item itemDto = new Item(itemId);
            cartDtoList.add(new Cart(itemDto, memberDto));
        }
        return cartDtoList;
    }

}
