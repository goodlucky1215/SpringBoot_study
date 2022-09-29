package hello.refactoring.Chapter10;

/*
* 메서드를 매개변수로 전환
* 여러 메서드가 기능은 비슷하고 안에 든 값만 다를 땐
* 서로 다른 값을 하나의 매개변수로 전달받는 메서드를 하나 작성하자.
* */
public class ParameterizeV1 {

    protected double baseCharge(double lastUasge){
        double result = Math.min(lastUasge, 100) * 0.03;
        if(lastUasge>100){
            result +=  (Math.min(lastUasge, 200) - 100) * 0.05;
        }
        if(lastUasge>200){
            result += lastUasge - 200 * 0.07;
        }
        return result;
    }

}
