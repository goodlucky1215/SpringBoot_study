package hello.refactoring.Chapter8;

import java.util.Dictionary;
import java.util.Hashtable;

/*
* 참조를 값으로 전환
*
* 참조 객체를 사용한 작업이 복잡해지는 순간이 참조를 값으로 바꿔야 할 시점이다.
*
* 값 객체는 분산 시스템이나 병렬 시스템에 주로 사용한다.
* 값 객체는 변경할 수 없어야한다는 주요 특서이 있다. 항상 결과가 같아야한다.
* 그래서 어떤 객체를 수정했을 때 다른 객첵체들도 바뀌는지 확인해야하는데,
* 가장 쉬운 벙법이 참조 객체로 바꾸는 것일 정도로 힘든 일이다.
* */
public class ChangeReferenceToValueV1 {

    public static void main(String[] args) {
        new Currency("USD").main();
    }

    static class Currency{

        private String _code;

        public void main() {
            Currency usd = Currency.get("USD");
            boolean result = new Currency("USD").equals(new Currency("USD")); //false 반환
            System.out.println("결과 => "+result);
        }

        private static Dictionary _instances = new Hashtable();

        private void store(){
            _instances.put(this.getCode(), this);
        }

        static void loadCustomer(){
            new Currency("USD").store();
            new Currency("KR").store();
            new Currency("JP").store();
        }

        public static Currency get(String name){
            return (Currency) _instances.get(name);
        }

        public String getCode() {
            return _code;
        }

        public Currency(String code){
            _code = code;
        }

        //euqls랑 hashcode 메서드가 빠지면 false로 나옴.
        public boolean equals(Object arg){
            if(! (arg instanceof Currency)) return false;
            Currency other = (Currency) arg;
            return (_code.equals(other._code));
        }
        public int hashCode(){
            return _code.hashCode();
        }
    }
}