package hello.refactoring.Chapter8;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

/*
* 값을 참조로 전환
* 클래스에 같은 인스턴스가 많이 들어 있어서 이것들을 하나의 객체로 바꿔야 할 땐
* 그 객체를 참조 객체로 전환하자.
* 
* 객체를 참조 객체와 값 객체로 분류할 수 있다.
* - 참조 객체 : 고객이나 계좌 같은 것. 현실에서의 한 객체에 대응 => 같은지 검사할 때는 객체ID 사용
* - 값 객체 : 날짜나 돈 같은 것. 전적으로 데이터 값을 통해서만 정의 => 같은지 검사할 때는 equals메서드와 hashCode메서드 재정의
* */
public class ChangeValueToReferenceV2 {

    private static int numbereOfOrderFor(Collection orders, String customer){

        int result = 0;
        Iterator iter = orders.iterator();
        while(iter.hasNext()){
            ReplaceDataValueWithObjectV2.Order each = (ReplaceDataValueWithObjectV2.Order) iter.next();
            if(each.getCustomerName().equals(customer)) result++;
        }
        return  result;
    }

    class Order{

        private Customer _customer;

        //2. 생성자 호출을 팩토리 메서드 호출로 수정 => getNamed로 메서드이름 변경
        public Order(String customerName){
            //_customer = Customer.create(customerName);
            _customer = Customer.getNamed(customerName);
        }

        public String getCustomerName() {
            return _customer.getName();
        }

        public void setCustomerName(String customer) {
            this._customer = new Customer(customer);
        }

    }

    static class Customer{

        private static Dictionary _instances = new Hashtable();

        private void store(){
            _instances.put(this.getName(), this);
        }

        static void loadCustomer(){
            new Customer("car center").store();
            new Customer("gas sdfsdf").store();
            new Customer("커피 자판기 운영업").store();
        }

        //1. 생성자를 팩토리 메서드로 전환 => 팩토리 메서드를 수정해서 Customer instance를 반환한다.
        // => Customer instance를 반환하므로 메서드명을 getNamed로 변경을 실시해서 확실히 나타내야한다.
        //public static Customer create(String name){
        public static Customer getNamed(String name){
            return (Customer) _instances.get(name);
        }

        private final String _name;

        //3. 생성자 메서드를 private하게 변경
        private Customer(String name){
            _name = name;
        }

        public String getName(){
            return _name;
        }

    }
}
