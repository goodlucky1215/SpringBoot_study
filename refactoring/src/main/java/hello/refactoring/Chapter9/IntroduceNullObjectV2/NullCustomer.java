package hello.refactoring.Chapter9.IntroduceNullObjectV2;

public class NullCustomer extends Customer{
    public boolean isNull(){
        return true;
    }

    public String getName() {
        return "nameEmpty";
    }

    public BillingPlan getPlan(){
        return BillingPlan.special();
    }

    public PaymentHistory getHistory(){
        return PaymentHistory.newNull();
    }
}
