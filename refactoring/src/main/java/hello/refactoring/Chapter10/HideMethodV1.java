package hello.refactoring.Chapter10;

/*
* 메서드 은폐
* 메서드가 다른 클래스에 사용되지 않는다면
* 그 메서드는 private타입으로 만든다.
* */
public class HideMethodV1 {

    public void aMethod(){
        System.out.println("난 HideMethodV1에서만 사용할 메서드야");
    }

    public static void main(String[] args) {
        new HideMethodV1().aMethod();
    }
}
