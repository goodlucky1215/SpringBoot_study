package hello.refactoring.Chapter9.IntroduceNullObjectV1;

public class Customer {

    public String getName() {
        return "naame";
    }

    public BillingPlan getPlan(){
        return new BillingPlan();
    }

    public PaymentHistory getHistory(){
        return new PaymentHistory();
    }

}
