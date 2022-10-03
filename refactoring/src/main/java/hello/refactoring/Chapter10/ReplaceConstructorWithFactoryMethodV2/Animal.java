package hello.refactoring.Chapter10.ReplaceConstructorWithFactoryMethodV2;

public class Animal {
    static final int RABBIT = 0;
    static final int CAT = 1;
    static final int HAMSTER = 2;
    static final String packageName = "hello.refactoring.Chapter10.ReplaceConstructorWithFactoryMethodV2.";

    static Animal create(int type){
        switch (type){
            case RABBIT:
                return create("Rabbit");
            case CAT:
               return create("Cat");
            case HAMSTER:
                return create("Hamster");
            default:
                throw new IllegalArgumentException("없는 동물 입니다.");
        }
    }

    static Animal create(String name) {
        try{
            return (Animal) Class.forName(packageName+name).newInstance();
        }catch (Exception e){
            throw new IllegalArgumentException("객체"+name+"인스턴스화 할 수 없다");
        }
    }

    void speak(){};
}
