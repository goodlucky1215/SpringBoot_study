package hello.Pattern.Ch4.factory.pratice.store;

import hello.Pattern.Ch4.factory.pratice.pizzakind.ChicagClamPizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.ChicagoCheesePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.ChicagoVeggiePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.Pizza;

public class ChicagoStore extends PizzaStoreFactory{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new ChicagoCheesePizza();
        }else if(type.equals("clam")){
            pizza = new ChicagClamPizza();
        }else if(type.equals("veggie")){
            pizza = new ChicagoVeggiePizza();
        }

        return pizza;
    }
}
