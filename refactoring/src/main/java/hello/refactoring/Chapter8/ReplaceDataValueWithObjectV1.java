package hello.refactoring.Chapter8;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/*
* 데이터 값을 객체로 전환
*
* 신용등급이나 주소 같은 것을 추가할 수는 없다.
* Customer은 값 객체로 취급하기 때문이다.
* 새로운 속성 추가하려면 Customer에 값을 참조로 전환을 적용해서
* 한 고객의 모든 주문이 하나의 Customer객체를 사용하게해야한다. => ChangeValueToReference참고
* */
public class ReplaceDataValueWithObjectV1 {

    private static int numbereOfOrderFor(Collection orders, String customer){

        int result = 0;
        Iterator iter = orders.iterator();
        while(iter.hasNext()){
            Order each = (Order) iter.next();
            if(each.getCustomer().equals(customer)) result++;
        }
        return  result;
    }

    class Order{
        private String _customer;

        public Order(String customer){
            _customer = customer;
        }
        public String getCustomer() {
            return _customer;
        }

        public void setCustomer(String customer) {
            this._customer = customer;
        }

    }

    class Customer{

        private final String _name;

        public Customer(String name){
            _name = name;
        }

        public String getName(){
            return _name;
        }

    }
}
