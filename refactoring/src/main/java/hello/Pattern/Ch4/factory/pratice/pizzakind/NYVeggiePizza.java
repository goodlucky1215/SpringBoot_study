package hello.Pattern.Ch4.factory.pratice.pizzakind;

import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;

public class NYVeggiePizza extends Pizza{

    public NYVeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        super.prepare();
    }

}
