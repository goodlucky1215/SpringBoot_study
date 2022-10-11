package hello.Pattern.Ch1.Strategy.pratice.fly;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("날수가 없지만...하나도 부럽지가 않아~~난 네가 나는게 부럽지가 않아~");
    }
}
