package hello.Pattern.Ch4.factory.pratice.pizzakind;

import hello.Pattern.Ch4.factory.pratice.ingredient.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    public Pizza(PizzaIngredientFactory pizzaIngredientFactory){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    Cheese cheese;
    Dough dough;
    Sauce sauce;
    Clams clams;

    List<String> toppings = new ArrayList<>();

    public void prepare(){
        cheese = pizzaIngredientFactory.createCheese();
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
    };

    public void bake(){
        System.out.println("175도에서 25분간 굽기");
    }
    public void cut(){
        System.out.println("피자를 사선으로 자르기");
    }
    public void box(){
        System.out.println("상자에 피자 담기");
    }
}
