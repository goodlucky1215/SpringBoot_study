package hello.Pattern.Ch3.decorator.pratice;

public class OrderCoffeeSimulator {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription()+"은 "+beverage.cost()+"원 입니다.");
        beverage = new Whipping(beverage);
        System.out.println(beverage.getDescription()+"은 "+beverage.cost()+"원 입니다.");
    }
}
