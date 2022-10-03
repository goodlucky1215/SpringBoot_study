package hello.refactoring.Chapter10;

/*
객체가 A메서드를 호출해서 그 결과를 B메서드에 매개변수로 전달하는데,
결과를 매개변수로 받는 B메서드로 직접 A메서드를 호츨 할 수 있을 땐
매개변수를 없얘고 A메서드를 B메서드가 호출하게 하자.
* */
public class ReplaceParameterWithMethodV1 {
        int _quantity;
        int _itemPrice;

    public double getPrice(){
        int basePrice = _quantity * _itemPrice;
        int discountLevel;
        if(_quantity > 100) discountLevel = 2;
        else discountLevel = 1;
        double finalPrice = discountedPrice(basePrice, discountLevel);
        return finalPrice;
    }

    private double discountedPrice(int basePrice, int discountLevel) {
        if(discountLevel == 2) return basePrice * 0.1;
        else return basePrice * 0.05;
    }
}
