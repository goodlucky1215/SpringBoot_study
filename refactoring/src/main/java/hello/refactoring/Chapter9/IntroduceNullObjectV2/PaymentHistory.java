package hello.refactoring.Chapter9.IntroduceNullObjectV2;

public class PaymentHistory {

    public static PaymentHistory newNull() {
        return new NullPaymentHistory();
    }

    int getWeekDelinquentInLastYear(){
        return 100;
    }
}
