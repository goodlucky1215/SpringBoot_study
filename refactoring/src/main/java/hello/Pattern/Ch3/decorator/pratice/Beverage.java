package hello.Pattern.Ch3.decorator.pratice;

/*
* 데코레이션 패턴
*
* */
public abstract class Beverage {
    String description = "제목 없음";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
