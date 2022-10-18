package hello.Pattern.Ch4.factory.easy;

import hello.Pattern.Ch4.template.Dog;

public class AnimalTest {

    public static void main(String[] args) {
        //AnimalTemplate dog = new Dog();
        //System.out.println(dog.getName());

        AnimalFactory af = new AnimalFactoryReturn();
        Animal dog = af.factoryReturn("dog");
    }
}
