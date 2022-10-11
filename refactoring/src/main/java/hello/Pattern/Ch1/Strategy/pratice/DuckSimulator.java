package hello.Pattern.Ch1.Strategy.pratice;

import hello.Pattern.Ch1.Strategy.pratice.fly.FlyNoWay;

public class DuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        System.out.println("==================그런데 다쳐서 날지 못하게 된다...=================");
        mallard.setFlyBehavior(new FlyNoWay());//이렇게 setter를 해서(캡슐화를 통해서)
        mallard.performFly();//값을 변경할 수 있게 만드는게 전략패턴이다. => 내가 원하는 클래스로 유연하게 변경해서 사용이 가능하다.
    }
}
