package hello.Pattern.Ch4.factory.pratice.store;

import hello.Pattern.Ch4.factory.pratice.pizzakind.NYCheesePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.NYClamPizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.NYVeggiePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.Pizza;

public class NYStore extends PizzaStoreFactory{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new NYCheesePizza();
        }else if(type.equals("clam")){
            pizza = new NYClamPizza();
        }else if(type.equals("veggie")){
            pizza = new NYVeggiePizza();
        }

        return pizza;
    }
}
