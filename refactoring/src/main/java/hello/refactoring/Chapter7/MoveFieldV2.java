package hello.refactoring.Chapter7;

/*
* 필드 이동
* 어떤 필드가 자신이 속한 클래스보다 다른 클래스에서 더 많이 사용될 때는
* 대상 클래스 안에 새 필드를 선안하고 그 필드 참조 부분을 새 필드 참조로 수정하자.
* */
public class MoveFieldV2 {

    class Account {
        private AccountType _type;

        double interestForAmountAndDays (double amount, int days){
            return getInterestRate() * amount * days / 365;
        }

        //자체 캡슐화
        //클래스로 많은 작업을 수행할 때 사용하면 좋다.
        //또한 메서드를 대상 클래스로 옮기는 메서드 이동 기법의 사용이 간편해진다.
        void setInterestRate(double arg){
            _type.setInterestRate(arg);
        }

        double getInterestRate() {
            return _type.getInterestRate();
        }
    }

    class AccountType{

        private double _interestRate;

        void setInterestRate(double arg){
            _interestRate = arg;
        }

        double getInterestRate() {
            return _interestRate;
        }
    }
}
