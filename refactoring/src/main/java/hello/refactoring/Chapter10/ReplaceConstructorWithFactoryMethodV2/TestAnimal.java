package hello.refactoring.Chapter10.ReplaceConstructorWithFactoryMethodV2;

public class TestAnimal {

    public static void main(String[] args) {

       Animal animal = Animal.create(Animal.CAT);
       animal.speak();
    }
}

