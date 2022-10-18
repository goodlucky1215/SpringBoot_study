package hello.Pattern.Ch4.factory.easy;

/*
* 팩토리 메서드랑 템플릿 메서드가 헷갈려서 만듬.
*
*
* */
abstract class Animal {

    public abstract String getName();

    public String hello(){
        return getName()+" 입니다.";
    }
}
