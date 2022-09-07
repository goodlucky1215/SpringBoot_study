package hello.refactoring.Chapter6;

/*
* 임시변수를 메서드 호출로 전환
* 상황) 임시변수가 여러개 일 때
* */
public class ReplaceTempWithQueryV4 {

    double _quantity;
    double _itemPrice;


    public double getPrice(){

        // 1. 임시변수를 final로 선언하여 그 임시변수들이 값을 한 번만 대입 받는지 시험해볼 수 있다.
        // => 그래야 메서드 호출 시 문제발생을 줄이기 좋다!!
        // 2. 메서드 호출로 변경 시 처음에는 private로 호출하기.
        return discountFactor() * basePrice();
        
    }

    private double discountFactor() {
        if(basePrice() > 1000) return 0.95;
        else return 0.98;
    }

    private double basePrice() {
        double basePrice = _quantity * _itemPrice;
        return basePrice;
    }
}
