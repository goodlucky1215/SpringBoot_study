package hello.Pattern.Ch3.decorator.pratice;

public abstract class CondimentDecorator extends Beverage{
    Beverage beverage;

    public abstract String getDescription();

    @Override
    public double cost() {
        return 0;
    }
}
