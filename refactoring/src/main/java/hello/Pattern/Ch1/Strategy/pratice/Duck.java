package hello.Pattern.Ch1.Strategy.pratice;

import hello.Pattern.Ch1.Strategy.pratice.fly.FlyBehavior;
import hello.Pattern.Ch1.Strategy.pratice.quack.QuackBehavior;

public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void swim(){
        System.out.println("진짜 오리든 가짜 오리든 모두 물에 뜬다~");
    }
}
