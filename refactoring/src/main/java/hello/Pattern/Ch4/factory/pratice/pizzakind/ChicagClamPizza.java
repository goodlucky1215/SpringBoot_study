package hello.Pattern.Ch4.factory.pratice.pizzakind;

import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;

public class ChicagClamPizza extends Pizza{


    public ChicagClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
    }

    @Override
    public void prepare() {
        cheese = pizzaIngredientFactory.createCheese();
        System.out.println(cheese.toString());
        cheese = pizzaIngredientFactory.createCheese();
        System.out.println(cheese.toString());
    }


}
