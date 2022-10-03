package hello.refactoring.Chapter10;

/*
매개변수 세트를 메서드로 전환
객체가 A메서드를 호출해서 그 결과를 B메서드에 매개변수로 전달하는데,
결과를 매개변수로 받는 B메서드로 직접 A메서드를 호츨 할 수 있을 땐
매개변수를 없얘고 A메서드를 B메서드가 호출하게 하자.
* */
public class ReplaceParameterWithMethodV2 {
        int _quantity;
        int _itemPrice;

    public double getPrice(){
        return discountedPrice();
    }

    private double discountedPrice() {
        if(getDiscountLevel() == 2) return getBasePrice() * 0.1;
        else return getBasePrice() * 0.05;
    }

    private double getBasePrice(){
        return _quantity * _itemPrice;
    }

    private int getDiscountLevel(){
        if(_quantity > 100) return 2;
        else return 1;
    }

}
