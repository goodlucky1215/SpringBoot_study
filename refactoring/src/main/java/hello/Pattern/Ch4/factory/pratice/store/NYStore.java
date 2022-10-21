package hello.Pattern.Ch4.factory.pratice.store;

import hello.Pattern.Ch4.factory.pratice.ingredient.ChicagoPizzaIngredient;
import hello.Pattern.Ch4.factory.pratice.ingredient.NYPizzaIngredient;
import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;
import hello.Pattern.Ch4.factory.pratice.pizzakind.NYCheesePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.NYClamPizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.NYVeggiePizza;
import hello.Pattern.Ch4.factory.pratice.pizzakind.Pizza;

public class NYStore extends PizzaStoreFactory{

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredient();
        if(type.equals("cheese")){
            pizza = new NYCheesePizza(pizzaIngredientFactory);
            pizza.setName("뉴욕 치즈 피자");
        }else if(type.equals("clam")){
            pizza = new NYClamPizza(pizzaIngredientFactory);
            pizza.setName("뉴욕 조개 피자");
        }else if(type.equals("veggie")){
            pizza = new NYVeggiePizza(pizzaIngredientFactory);
            pizza.setName("뉴욕 야채 피자");
        }

        return pizza;
    }
}
