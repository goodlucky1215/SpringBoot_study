package hello.refactoring.Chapter7;

/*
* 메서드 이동
* 메서드가 자신이 속한 클래스보다 다른 클래스의 기능을 더 많이 이용할 땐
* 그 메서드가 제일 많이 이용하는 클래스 안에서 비슷한 내용의 새 메서드를 작성하자.
* 기존 메서드는 간단한 대리 메서드로 전환하든지 아예 삭제하자.
* */
public class MoveMethodV1 {

    class Account{

        private final AccountType _type = new AccountType();
        private final int _daysOverdrawn = 12;

        double overdraftCharge(){
            if(_type.isPremium()){
                double result = 10;
                if(_daysOverdrawn > 7) result += (_daysOverdrawn -7)*0.85;
                return  result;
            }
            else return _daysOverdrawn * 1.75;
        }
    }

    class AccountType{

        boolean isPremium(){
            return false;
        }
    }
}
