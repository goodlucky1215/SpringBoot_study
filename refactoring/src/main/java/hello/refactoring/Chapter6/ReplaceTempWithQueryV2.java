package hello.refactoring.Chapter6;

/*
* 임시변수를 메서드 호출로 전환
* 상황) 임시변수가 한개 일 때
* */
public class ReplaceTempWithQueryV2 {

    double _quantity;
    double _itemPrice;


    public double getPrice(){

        // 수식의 결과를 저장하는 임시변수가 있을 땐,
        // 수식으 빼내어 메서드로 만든 후, 참조 부분을 전부 수식으로 교체하자.
        // 새로 만든 메서드는 다른 메서드에서 호출 가능하다.
        // => "메서드 추출" 전에는 "메서드 호출"로 전환을 먼저 적용해야한다. 그래야 메서드 추출이 쉬어진다.
        //    지역변수(임시변수)가 많을수록 메서드 추출이 힘들어지기 때문이다.
        if(basePrice() > 1000) return basePrice() * 0.95;
        else return basePrice() * 0.98;
        
    }

    private double basePrice() {
        double basePrice = _quantity * _itemPrice;
        return basePrice;
    }
}
