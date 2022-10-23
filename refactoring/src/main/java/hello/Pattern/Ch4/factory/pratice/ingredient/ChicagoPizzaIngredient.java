package hello.Pattern.Ch4.factory.pratice.ingredient;

public class ChicagoPizzaIngredient implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new DoughThickShin();
    }

    @Override
    public Sauce createSauce() {
        return new SauceRench();
    }

    @Override
    public Cheese createCheese() {
        return new CheeseReggiano();
    }

    //@Override
    //public Veggies[] createVeggies() { return new Veggies[0];}

    @Override
    public Clams createClam() {
        return new ClamFish();
    }
}
