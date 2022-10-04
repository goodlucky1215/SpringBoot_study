package hello.refactoring.Chapter11.PullUpConstructorBodyV2;

public class Manager extends Employee {
    private int _grade;

    public Manager(String id,String name, int grade){
        super(id,name);
        _grade = grade;
    }
}
