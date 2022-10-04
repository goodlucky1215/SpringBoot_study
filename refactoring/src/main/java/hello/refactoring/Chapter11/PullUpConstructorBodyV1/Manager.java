package hello.refactoring.Chapter11.PullUpConstructorBodyV1;

public class Manager extends Employee{
    private int _grade;

    public Manager(String name,String id,int grade){
        _name = name;
        _id = id;
        _grade = grade;
    }
}
