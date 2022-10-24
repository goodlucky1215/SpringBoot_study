package hello.Pattern.Ch5.singleton.pratice;

/*
* getInstance는 정적메소드로 클래스 메소드라고 불린다.
* 이걸 이용하면 생성자를 private로 막아둬도
* 인스턴스를 생성할 수 있다.
* */
public class SingletonV2 {

    private SingletonV2(){}

    public static SingletonV2 getInstance(){
        return new SingletonV2();
    }

}
