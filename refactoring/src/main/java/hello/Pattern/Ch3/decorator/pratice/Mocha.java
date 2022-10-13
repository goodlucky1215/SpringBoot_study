package hello.Pattern.Ch3.decorator.pratice;

import hello.Pattern.Ch3.decorator.pratice.Beverage;
import hello.Pattern.Ch3.decorator.pratice.CondimentDecorator;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", 모카";
    }

    public double cost(){
        return beverage.cost() + 600;
    }
}
