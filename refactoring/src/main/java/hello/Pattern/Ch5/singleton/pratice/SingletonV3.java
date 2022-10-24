package hello.Pattern.Ch5.singleton.pratice;

/*
* 고전적인 싱글턴 패턴
* */
public class SingletonV3 {

    private static SingletonV3 instance;
    private SingletonV3(){}

    public static SingletonV3 getInstance(){
        if(instance==null){
            instance = new SingletonV3();
        }
        return instance;
    }

}
