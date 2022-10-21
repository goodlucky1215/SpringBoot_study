package hello.Pattern.Ch4.factory.pratice.store;

import hello.Pattern.Ch4.factory.pratice.ingredient.ChicagoPizzaIngredient;
import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;
import hello.Pattern.Ch4.factory.pratice.pizzakind.ChicagClamPizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.ChicagoCheesePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.ChicagoVeggiePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.Pizza;

public class ChicagoStore extends PizzaStoreFactory{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredient();
        if(type.equals("cheese")){
            pizza = new ChicagoCheesePizza(pizzaIngredientFactory);
            pizza.setName("시카고 치즈 피자");
        }else if(type.equals("clam")){
            pizza = new ChicagClamPizza(pizzaIngredientFactory);
            pizza.setName("시카고 조개 피자");
        }else if(type.equals("veggie")){
            pizza = new ChicagoVeggiePizza(pizzaIngredientFactory);
            pizza.setName("시카고 야채 피자");
        }

        return pizza;
    }
}
