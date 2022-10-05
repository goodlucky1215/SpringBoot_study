package hello.refactoring.Chapter11.TamplateMethod;

/*
* 템플릿 메서드 형성
* 하위클래스 안의 두 메서드가 거의 비슷한 단계들을 같은 순서로 수행할 땐
* 그 단계들을 시그너처가 같은 두 개의 메서드로 만들어서 두 원본 메서드를 같게 만든 후
* 두 메서드를 상위클래스로 옮기자.
* */
public abstract class Animal {

    public void value(){
        System.out.println("======== START ==========");
        String isSound = getSound();
        String food = getFood();
        int kind = getKind();
        System.out.println("======== END ==========");
    }

    abstract int getKind();

    abstract String getFood();

    abstract String getSound();
}
