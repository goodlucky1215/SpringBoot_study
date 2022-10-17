package hello.Pattern.Ch4.factory.pratice;

public abstract class PizzaStore {

    abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type){
        Pizza pizza;

        // 피자 종류 고르기
        pizza = createPizza(type);

        // 어떤 피자여도 준비 과정은 똑같다!!
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
