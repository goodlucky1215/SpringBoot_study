package hello.Pattern.Ch4.factory.pratice.pizzakind;

import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;

public class ChicagoVeggiePizza extends Pizza{


    public ChicagoVeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        super.prepare();
    }

}
