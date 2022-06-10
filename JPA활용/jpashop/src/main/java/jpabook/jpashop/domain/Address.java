package jpabook.jpashop.domain;

import lombok.Getter;
import javax.persistence.Embeddable;

//값 타입은 변경 불가능하게 설계해야한다. 그래서 Setter가 없고, 생성자에서 초기화시키는 것이다.
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    //이걸 안하면 클래스에 빨간불이 뜸 왜?
    //jpa같은 경우에는 리플렉션이나 proxy를 써야 클래스를 생성하는데
    //기본생성자가 있어야만할 수 있다.
    //그래서  Address(String city,String street,String zipcode)
    //이런 파라미터가 들어간 생성자를 만들었다면, 따로 기본 생성자를 만들어
    //줘야한다.
    //그런데 public으로하면 호출이 많이 될 수 있으므로, protected로 해준다.
    protected Address(){

    }

    public Address(String city,String street,String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;

    }
}
