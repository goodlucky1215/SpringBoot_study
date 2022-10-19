package hello.Pattern.Ch4.factory.pratice;

import hello.Pattern.Ch4.factory.pratice.pizzakind.Pizza;
import hello.Pattern.Ch4.factory.pratice.store.ChicagoStore;
import hello.Pattern.Ch4.factory.pratice.store.NYStore;
import hello.Pattern.Ch4.factory.pratice.store.PizzaStoreFactory;

public class PizzaTest {

    public static void main(String[] args) {
        PizzaStoreFactory chicagoStore = new ChicagoStore();
        Pizza chpizza = chicagoStore.orderPizza("cheese");

        System.out.println("////////////////////////////////////////");

        PizzaStoreFactory nyStore = new NYStore();
        Pizza nypizza = nyStore.orderPizza("clam");

    }

}
