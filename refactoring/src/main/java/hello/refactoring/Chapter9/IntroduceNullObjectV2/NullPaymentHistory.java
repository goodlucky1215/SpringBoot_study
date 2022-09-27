package hello.refactoring.Chapter9.IntroduceNullObjectV2;

public class NullPaymentHistory extends PaymentHistory{

    int getWeekDelinquentInLastYear(){
        return 0;
    }
}
