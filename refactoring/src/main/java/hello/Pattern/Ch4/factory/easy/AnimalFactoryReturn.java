package hello.Pattern.Ch4.factory.easy;

public class AnimalFactoryReturn  extends AnimalFactory{


    @Override
    Animal factoryReturn(String str) {
        switch (str){
            case "dog" : return new Dog();
            case "cat" : return new Cat();
        }
        return null;
    }
}
