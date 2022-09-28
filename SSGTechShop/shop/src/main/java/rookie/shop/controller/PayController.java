package rookie.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rookie.shop.service.PayService;

import java.util.List;
import java.util.Map;


//결제 화면과 관련된 이벤트
@Controller
@RequiredArgsConstructor
public class PayController {

    private final PayService payService;


    //1. way = direct : 아이템 목록 => 구매 목록 리스트(바로 구매)
    //2. way = cart   : 장바구니    => 구매 목록 리스트 @PathVariable("param") List<Long> param
    @GetMapping("/itemBuy/{way}/{param}")
    public String itemBuyPage(@PathVariable("way") String way,@PathVariable("param") List<Integer> param, Model model){
        Map<String,Object> map = null;
        if("direct".equals(way)){
            map = payService.directItemBuy(param.get(0).longValue(), Math.toIntExact(param.get(1)));
        }
        else if("cart".equals(way)) {
            map = payService.cartItemBuy(param);
        }
        model.addAttribute("result",map);
        model.addAttribute("way",way);
        if((boolean)map.get("result")) {
            model.addAttribute("itemBuyList",map.get("itemBuyList"));
            return "payHome :: payHomeSuccess";
        }else{
            return "payHome :: payHomeFail";
        }
    }

    //결제 버튼 클릭
    @PostMapping("/payItem")
    @ResponseBody
    public Map<String,Object> payItem(@RequestBody  Map<String, Object> param){
        String way = (String) param.get("way");
        Map<String,Object> map = null;
        if("direct".equals(way)){
            List<Integer> itemIdList = (List<Integer>) param.get("checkItems");
            List<Integer> quantityList = (List<Integer>) param.get("quantityItems");
            map = payService.payItem(itemIdList.get(0).longValue(), quantityList.get(0));
        }
        else if("cart".equals(way)) {
            List<Integer> itemIdList = (List<Integer>) param.get("checkItems");
            map = payService.payItem(itemIdList);
        }
        return map;
    }


}
