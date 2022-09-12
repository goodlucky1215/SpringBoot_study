package hello.refactoring.Chapter8;

import java.util.HashSet;
import java.util.Set;

/*
* 클래스의 단방향 연결을 양방향으로 전환
* 두 클래스가 서로의 기능을 사용해야 하는데 한 방향으로만 연결되어 있을 땐
* 역 포인터를 추가하고 두 클래스를 모두 업데이트할 수 있게 접근 한정자를 수정하자.
*
* 예시2: 하나의 주문을 여러 고객이 가능(N:N)
* 고객은 addOrder로 주문을 하고
* 주문은 setCustomer로 주문이 들어온 경우 다른 고객이 주문을 한 것을 지우고, 새로운 고객을 넣고 있다.
* */
public class ChaingeUnidirectToBidirectV2 {

    class Order{

        private Set _customer = new HashSet();
        
        Set getCustomer(){
            return _customer;
        }

        //하나의 주문을 여러 고객이 가능
        void addCustomer(Customer customer){
            customer.friendOrders().add(this);
            _customer.add(customer);
        }

        void removeCustomer(Customer customer){
            customer.friendOrders().remove(this);
            _customer.remove(customer);
        }
    }

    class Customer{
        private Set _orders = new HashSet();

        Set friendOrders(){
            return _orders;
        }
        void addOrder(Order arg){
            arg.addCustomer(this);
        }
        void removeOrder(Order arg){
            arg.removeCustomer(this);
        }
    }
}
