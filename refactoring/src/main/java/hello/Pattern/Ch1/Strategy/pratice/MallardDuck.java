package hello.Pattern.Ch1.Strategy.pratice;

import hello.Pattern.Ch1.Strategy.pratice.fly.FlyWithWings;
import hello.Pattern.Ch1.Strategy.pratice.quack.Quack;

public class MallardDuck extends Duck{
    
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    
    @Override
    public void display() {
        System.out.println("나는 물오리");
    }
}
