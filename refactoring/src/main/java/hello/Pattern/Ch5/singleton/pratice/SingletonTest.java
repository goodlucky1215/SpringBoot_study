package hello.Pattern.Ch5.singleton.pratice;

public class SingletonTest {

    public static void main(String[] args) {
        //SingletonV1 singletonV1 = new SingletonV1(); // error, private라서 호출이 안된다.
        SingletonV2 singletonV2 = SingletonV2.getInstance();
    }
}
