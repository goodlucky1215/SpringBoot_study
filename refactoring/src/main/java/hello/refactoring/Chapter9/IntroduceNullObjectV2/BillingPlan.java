package hello.refactoring.Chapter9.IntroduceNullObjectV2;

public class BillingPlan {

    public static BillingPlan special() {
        return new BillingPlan();
    }
}
