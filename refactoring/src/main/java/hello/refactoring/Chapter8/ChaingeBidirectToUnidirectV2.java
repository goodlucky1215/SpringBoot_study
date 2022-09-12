package hello.refactoring.Chapter8;

import java.util.HashSet;
import java.util.Set;

/*
* 클래스를 양방향 연결을 단방향으로 전환
* 양방향으로 연결되어 있는데 한 클래스가 다른 클래스의 기능을 더 이사 사용하지 않게 됐을 땐
* 불필요한 방향의 연결을 끊자.
*
* 양방향 연결은 좀비 객체가 발생하기 쉽다. (좀비 객체라 참조가 삭제되지 않아 제거 되야함에도 남아 떠도는 객체를 의미)
* 양방향 연결은 종속 되서, 강한 결합력이 생긴다. 따라서 문제를 많이 발생 시킬 수 있다.
* */
public class ChaingeBidirectToUnidirectV2 {

    class Order{

    }

    //Customer가 있어야 Order가 있으므로 order클래스에서 cutomer로 가는 것을 끊어야 한다.
    class Customer{
        private Set _orders = new HashSet();

        Set friendOrders(){
            return _orders;
        }
        void addOrder(Order arg){
            _orders.add(arg);
        }
    }
}
