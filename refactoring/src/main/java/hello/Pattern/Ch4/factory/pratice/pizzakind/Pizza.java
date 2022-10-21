package hello.Pattern.Ch4.factory.pratice.pizzakind;

import hello.Pattern.Ch4.factory.pratice.ingredient.Cheese;
import hello.Pattern.Ch4.factory.pratice.ingredient.PizzaIngredientFactory;

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

    List<String> toppings = new ArrayList<>();

    public abstract void prepare();

    public void prepare1(){
        System.out.println("준비 중 : "+name);
        System.out.println("도우 ing : "+pizzaIngredientFactory.createDough());
        System.out.println("소스 ing : "+pizzaIngredientFactory.createSauce());
        System.out.print("토핑 ing : ");
        for(String topping:toppings){
            System.out.print(" "+topping);
        }
        System.out.println();
    }

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
