package hello.refactoring.Chapter7;

/*
* 필드 이동
* 어떤 필드가 자신이 속한 클래스보다 다른 클래스에서 더 많이 사용될 때는
* 대상 클래스 안에 새 필드를 선안하고 그 필드 참조 부분을 새 필드 참조로 수정하자.
* */
public class MoveFieldV1 {

    class Account {
        private AccountType _type;

        double interestForAmount_days (double amount, int days){
            //필드 캡슐화 _type.getInterestRate()
            return _type.getInterestRate() * amount * days / 365;
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
