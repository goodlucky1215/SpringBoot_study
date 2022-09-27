package hello.refactoring.Chapter9.IntroduceNullObjectV2;

public class Site {

    Customer _customer;

    public Customer getCustomer() {
        return (_customer == null) ? Customer.newNull() : _customer;
    }

    public void setCustomer(Customer _customer) {
        this._customer = _customer;
    }
}
