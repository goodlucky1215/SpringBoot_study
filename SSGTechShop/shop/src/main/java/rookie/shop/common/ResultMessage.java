package rookie.shop.common;

//공통으로 사용되는 결과 메시지
public class ResultMessage {

    public static final String chiceItemConfirm = "선택한 제품을 확인해주세요.";
    public static final String cartItemAdd = "장바구니에 추가 되었습니다.";
    public static final String cartItemEmpty = "장바구니에 제품이 없습니다.";
    public static final String cartItemDelete = "삭제가 완료되었습니다.";

    public String itemGetExceed(String itemName, int itemQuantity){
        return itemName+" 담을 수 있는 최대 수량은 "+itemQuantity+"개 입니다.";
    }

    public String itemPayExceed(String itemName, int itemQuantity){
        return itemName+" 구매 가능한 최대 수량은 "+itemQuantity+"개 입니다.";
    }

    public String cartItemQuantityAdd(int itemQuantity){
        return "장바구니에 이미 있으시군요! 장바구니에 추가되어 "+itemQuantity+"개가 되었습니다.";
    }

    public String cartItemQuantityChange(int itemQuantity){
        return "제품 수량이"+itemQuantity+"개로 변경되었습니다.";
    }

    public String resultPayment(Long totalPrice){
        return "총 결제 금액은 "+totalPrice+"원 입니다.";
    }
}
