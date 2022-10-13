package hello.Pattern.Ch3.decorator.pratice;

public class Whipping extends CondimentDecorator {

    public Whipping(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", 휘핑추가";
    }

    public double cost(){
        return beverage.cost() + 700;
    }
}
