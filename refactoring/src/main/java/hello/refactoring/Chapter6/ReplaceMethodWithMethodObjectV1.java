package hello.refactoring.Chapter6;

/*
* 메서드를 메서드 객체로 전환
* */
public class ReplaceMethodWithMethodObjectV1 {

    class Account{
        int gamma(int inputVal, int quantity, int yearToDate){
            int importantValue1 = (inputVal * quantity) + 123123;
            int importantValue2 = (inputVal * yearToDate) + 100;
            if((yearToDate - importantValue1)>100) importantValue2 -= 20;
            int importantValue3 = importantValue2 * 7;

            return importantValue3 - 2 * importantValue1;
        }
    }
}
