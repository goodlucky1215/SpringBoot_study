package hello.refactoring.Chapter6;

/*
* 임시변수를 메서드 호출로 전환
* 상황) 임시변수가 한개 일 때
*/
public class ReplaceTempWithQueryV1 {

    double _quantity;
    double _itemPrice;
    public double pricePercent(){

        double basePrice = _quantity * _itemPrice;
        if(basePrice > 1000) return basePrice * 0.95;
        else return basePrice * 0.98;

    }
}
