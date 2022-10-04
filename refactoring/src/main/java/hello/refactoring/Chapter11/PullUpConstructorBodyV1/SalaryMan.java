package hello.refactoring.Chapter11.PullUpConstructorBodyV1;

public class SalaryMan extends Employee{
    private int _money;

    public SalaryMan(String name, String id, int _money){
        _name = name;
        _id = id;
        _money = _money;
    }
}
