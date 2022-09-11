package hello.refactoring.Chapter8;

import java.util.Collection;
import java.util.Iterator;

/*
* 데이터 값을 객체로 전환
* */
public class ReplaceDataValueWithObjectV2 {

    private static int numbereOfOrderFor(Collection orders, String customer){

        int result = 0;
        Iterator iter = orders.iterator();
        while(iter.hasNext()){
            Order each = (Order) iter.next();
            if(each.getCustomerName().equals(customer)) result++;
        }
        return  result;
    }

    class Order{
        private Customer _customer;

        public Order(String customerName){
            _customer = new Customer(customerName);
        }
        public String getCustomerName() {
            return _customer.getName();
        }

        public void setCustomerName(String customer) {
            this._customer = new Customer(customer);
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
