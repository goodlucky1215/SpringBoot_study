package hello.Pattern.Ch4.factory.pratice.pizzakind;

import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;

public class ChicagoCheesePizza extends Pizza{


    public ChicagoCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        super.prepare();
    }

}
