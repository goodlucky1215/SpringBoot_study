package hello.refactoring.Chapter9.IntroduceNullObjectV2;

/*
* null값을 계속 검사하는 코드가 나올 땐
* null값을 널 객체로 만들자.
*
*
* */
public class UseTest {

    public static void main(String[] args) {
        Site site = new Site();
        Customer customer = site.getCustomer();
        BillingPlan plan = customer.getPlan();

        String customerName = customer.getName();

        int weeksDelinquent = customer.getHistory().getWeekDelinquentInLastYear();
    }
}
