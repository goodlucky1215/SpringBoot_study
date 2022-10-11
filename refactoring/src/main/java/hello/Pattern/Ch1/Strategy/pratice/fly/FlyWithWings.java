package hello.Pattern.Ch1.Strategy.pratice.fly;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("날아올라~~저하늘~~~푸른별될래요~~깊은밤~~~하늘에 빛이 되어~~");
    }
}
