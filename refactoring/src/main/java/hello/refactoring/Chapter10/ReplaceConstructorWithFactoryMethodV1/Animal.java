package hello.refactoring.Chapter10.ReplaceConstructorWithFactoryMethodV1;

public class Animal {

    private int _type;
    static final int RABBIT = 0;
    static final int CAT = 1;
    static final int HAMSTER = 2;
    Animal(){};
    Animal(int type){
        _type = type;
    }

    static Animal create(int type){
        switch (type){
            case RABBIT:
                return new Rabbit();
            case CAT:
                return new Cat();
            case HAMSTER:
                return new Hamster();
            default:
                throw new IllegalArgumentException("없는 동물 입니다.");
        }
    }
}
