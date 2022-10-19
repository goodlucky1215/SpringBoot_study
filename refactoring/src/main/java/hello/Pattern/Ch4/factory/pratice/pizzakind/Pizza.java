package hello.Pattern.Ch4.factory.pratice.pizzakind;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;

    List<String> toppings = new ArrayList<>();

    public void prepare(){
        System.out.println("준비 중 : "+name);
        System.out.println("도우 ing : "+dough);
        System.out.println("소스 ing : "+sauce);
        System.out.print("토핑 ing : ");
        for(String topping:toppings){
            System.out.print(" "+topping);
        }
        System.out.println();
    }

    public void bake(){
        System.out.println("175도에서 25분간 굽기");
    }
    public void cut(){
        System.out.println("피자를 사선으로 자르기");
    }
    public void box(){
        System.out.println("상자에 피자 담기");
    }
}
