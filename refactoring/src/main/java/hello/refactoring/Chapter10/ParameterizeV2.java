package hello.refactoring.Chapter10;

/*
* 메서드를 매개변수로 전환
* 여러 메서드가 기능은 비슷하고 안에 든 값만 다를 땐
* 서로 다른 값을 하나의 매개변수로 전달받는 메서드를 하나 작성하자.
* */
public class ParameterizeV2 {

    protected double baseCharge(double lastUasge){
        double result = usageInRange(lastUasge, 0,100)* 0.03;
        result += usageInRange(lastUasge, 100,200)* 0.05;
        result += usageInRange(lastUasge, 200,Integer.MAX_VALUE)* 0.07;
        return result;
    }

    protected double usageInRange(double lastUasge, int start, int end){
        if(lastUasge>start) return Math.min(lastUasge, end) - start;
        return 0;
    }

}
