package hello.Pattern.Ch3.decorator.pratice;

/*
* 데코레이션 패턴
* 객체에 추가요소를 동적으로 더할 수 있다.
* 서브클래스를 만들 때보다 훨씬 유연하게 기능을 확장할 ㅅ ㅜ있다.
* => OCP를 만족하는 패턴이다.
* 그러나 이 패턴을 사용하면 자잘한 객체가 매우 많이 추가 될 수 있다. =>
* 이를 팩토리와 빌더 패턴을 이용하면 문제를 도와 줄 수 있다.
* */
public abstract class Beverage {
    public enum Size { 
        TALL(0), GRANDE(500), VENTI(1000);
        int cost;
        Size(int cost) {
            this.cost = cost;
        }
    };

    Size size = Size.TALL;
    public void setSize(Size size){
        this.size = size;
    }
    public Size getSize(){
        return this.size;
    }
    String description = "제목 없음";

    public String getDescription(){
        return description;
    }

    public abstract double cost();

    public double costResult(){
        return cost()+getSize().cost;
    }
}
