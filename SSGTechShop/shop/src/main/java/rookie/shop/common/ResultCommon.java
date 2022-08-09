package rookie.shop.common;

import rookie.shop.dto.Cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//공통으로 사용되는 결과
public class ResultCommon {

    public Map resultMap(String message, boolean result){
        Map<String,Object> map = new HashMap<>();
        map.put("message",message);
        map.put("result",result);
        return map;
    }

    public Map resultMap(String message, boolean result, List<Cart> buyList){
        Map<String,Object> map = new HashMap<>();
        map.put("message",message);
        map.put("result",result);
        map.put("itemBuyList",buyList);
        return map;
    }

    public Map resultMap(Cart cart, String message, boolean result){
        Map<String,Object> map = new HashMap<>();
        map.put("cart", cart);
        map.put("message",message);
        map.put("result",result);
        return map;
    }
}
