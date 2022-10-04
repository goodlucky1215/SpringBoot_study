package hello.refactoring.Chapter11.PullUpConstructorBodyV2;

/*
* 생성자 내용 상향
* 하위클래스마다 비슷한 생성자가 있을 땐
* 상위클래스에 생성자를 작성하고, 하위클래스에서 상위클래스 생성자를 호출하도록 한다.
* */
public class Employee {
    protected String _id;
    protected String _name;

    Employee(String id, String name){
        _id = id;
        _name = name;
    }
}
