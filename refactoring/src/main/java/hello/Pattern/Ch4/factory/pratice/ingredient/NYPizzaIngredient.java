package hello.Pattern.Ch4.factory.pratice.ingredient;

public class NYPizzaIngredient implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

    @Override
    public Clams createClam() {
        return null;
    }
}
