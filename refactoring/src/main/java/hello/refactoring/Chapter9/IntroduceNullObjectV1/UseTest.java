package hello.refactoring.Chapter9.IntroduceNullObjectV1;

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
        BillingPlan plan;

        if(customer==null) plan = new BillingPlan();
        else plan = customer.getPlan();

        String customerName;
        if(customer == null) customerName = "nameEmpty";
        else customerName = customer.getName();

        int weeksDelinquent;
        if(customer == null) weeksDelinquent = 0;
        else weeksDelinquent = customer.getHistory().getWeekDelinquentInLastYear();
    }
}
