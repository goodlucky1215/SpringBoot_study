package hello.refactoring.Chapter10.ReplaceParameterWithExplicitMethodsV1;

/*
 * 매개변수를 메서드로 변환
 * 매개변수로 전달된 값에 따라 메서드가 다른 코드를 실행할 땐
 * 그 매개변수로 전달도딜 수 있는 모든 값에 대응하는 메서드를 각각 작성하자.
 * */
public class AnimalType {

    static final int Rabbit = 0;
    static final int Hamster = 1;
    static final int Dog = 2;

    static Animal create(int type){
        switch (type){
            case Rabbit:
                return new Rabbit();
            case Hamster:
                return new Hamster();
            case Dog:
                return new Dog();
            default:
                throw new IllegalArgumentException("없는 분류 부호 값");
        }
    }
}
