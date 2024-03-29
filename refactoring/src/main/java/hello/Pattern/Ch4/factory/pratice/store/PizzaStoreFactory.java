package hello.Pattern.Ch4.factory.pratice.store;

import hello.Pattern.Ch4.factory.pratice.pizzakind.Pizza;

/*
 * 그냥 한 클래스에 넣어도 되는데,
 * 이렇게 캡슐화하면 장점은?
 *
 * 피자 주문 외에도 만약에
 * 피자 메뉴 설명이나,
 * 피자 주문 처리 하는 등
 * 다른 곳에서도 이
 * 팩토리 클래스로 캡슐화 해 놓으면 이 하나만 고치면서 사용하면 된다.
 *
 * 펙토리 메서드 패턴이란?
 * 객체를 생성할 때 필요한 인터페이스를 만듭니다.
 * 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정합니다.
 * 팩토리 메서드 패턴을 사용하면 클래스 인스턴스를 만드는 일을 서브클래스에 맡기면 된다.
 * */
public abstract class PizzaStoreFactory {

    abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type){
        Pizza pizza;

        // 피자 종류 고르기
        pizza = createPizza(type);

        // 어떤 피자여도 준비 과정은 똑같다!!
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
