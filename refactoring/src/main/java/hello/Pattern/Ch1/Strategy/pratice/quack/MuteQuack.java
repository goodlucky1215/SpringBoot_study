package hello.Pattern.Ch1.Strategy.pratice.quack;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< 말을 할 순 업지만...행복해~~>>");
    }
}
