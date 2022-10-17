package hello.Pattern.Ch4.factory.pratice;

/*
* 그냥 한 클래스에 넣어도 되는데,
* 이렇게 캡슐화하면 장점은?
*
* 피자 주문 외에도 만약에
* 피자 메뉴 설명이나,
* 피자 주문 처리 하는 등
* 다른 곳에서도 이
* 팩토리 클래스로 캡슐화 해 놓으면 이 하나만 고치면서 사용하면 된다.
* */
public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new Pizza();
        }else if(type.equals("pepperoni")){
            pizza = new Pizza();
        }else if(type.equals("clam")){
            pizza = new Pizza();
        }else if(type.equals("veggie")){
            pizza = new Pizza();
        }

        return pizza;
    }
}
