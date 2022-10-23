package hello.Pattern.Ch4.factory.pratice.ingredient;

public class NYPizzaIngredient implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new DoughThinShin();
    }

    @Override
    public Sauce createSauce() {
        return new SauceSweete();
    }

    @Override
    public Cheese createCheese() {
        return new CheeseMoaazrella();
    }

    //@Override
    //public Veggies[] createVeggies() {
   //     return new Veggies[0];
    //}

    @Override
    public Clams createClam() {
        return new ClamShrimp();
    }
}
