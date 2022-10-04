package hello.refactoring.Chapter11.PullUpConstructorBodyV2;

public class SalaryMan extends Employee {
    private int _money;

    public SalaryMan(String id, String name, int _money){
        super(id,name);
        _money = _money;
    }
}
