package hello.Pattern.Ch4.template;

/*
* 팩토리 메서드랑 템플릿 메서드가 헷갈려서 만듬.
*
* 템플릿 메서드는 변하지 않는 기능은 부모에 변경되는 부분만 abstract로 확장
* 팩토리 메서드는 객체 생성을 직접 하지 않고, 하위 클래스가 어떤 객체를 생성할지
* 결정하도록 위임.
* */
abstract class AnimalTemplate {

    public abstract String getName();

    public String hello(){
        return getName()+" 입니다.";
    }
}
