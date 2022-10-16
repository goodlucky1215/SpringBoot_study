package hello.Pattern.Ch3.decorator.pratice;

public class OrderCoffeeSimulator {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription()+"은 "+beverage.costResult()+"원 입니다.");
        beverage = new Whipping(beverage);
        beverage.setSize(Beverage.Size.VENTI);
        System.out.println(beverage.getDescription()+"은 "+beverage.costResult()+"원 입니다.");
    }
}
