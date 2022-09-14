package hello.refactoring.Chapter8.ReplaceTypeCodeWitStateOrStrategyV1;

/*
* 분류 부호를 상태/전략 패턴으로 전환
* 이 기법은 ReplaceTypeCodeeWithSubclass와 비슷하지만,
* 분류 부호가 객체 생명주기 동안 변할 때나 다른 이유로 하위클래스로 만들 수 없을 때 사용.
* 이 기법은 상태 패턴이나 전략 패턴 중 하나를 사용.
*
* 상태 패턴 : 상태별 데이터를 이동하고 객체를 변화하는 상태일 때 적절
* 전략 패턴 : 조건문을 재정의 전환으로 하나의 알고리즘을 단순화해야 할 때 적절
* */
public class Employee {

    private int _type;
    private int _monthlySalary;
    private int _commission;
    private int _bonus;
    static final int ENCINEER = 0;
    static final int SALESMAN = 1;
    static final int TEACHERS = 2;

    Employee(int type){
        _type = type;
    }

    int payAmount(){
        switch (_type){
            case ENCINEER:
                return _monthlySalary;
            case SALESMAN:
                return _monthlySalary + _commission;
            case TEACHERS:
                return _monthlySalary + _bonus;
            default:
                throw new RuntimeException("사원이 잘못됨");
        }
    }
}
