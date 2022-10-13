package hello.Pattern.Ch3.decorator.pratice;

import hello.Pattern.Ch3.decorator.pratice.Beverage;

public class Espresso extends Beverage{

    public Espresso(){
        description = "에스프레소";
    }

    @Override
    public double cost() {
        return 4500;
    }
}
