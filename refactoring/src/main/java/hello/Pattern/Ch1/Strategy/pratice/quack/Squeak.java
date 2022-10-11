package hello.Pattern.Ch1.Strategy.pratice.quack;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("삐이이익!!");
    }
}
