package hello.refactoring.Chapter10.ReplaceConstructorWithFactoryMethodV1;

public class TestAnimal {

    public static void main(String[] args) {
        Animal animal = Animal.create(Animal.RABBIT);
    }
}
