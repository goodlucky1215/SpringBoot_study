package hello.refactoring.Chapter9.IntroduceNullObjectV2;


public class Customer implements NullableCustom {

    public boolean isNull(){
        return false;
    }

    static Customer newNull(){
        return new NullCustomer();
    }

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
