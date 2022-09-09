package hello.refactoring.Chapter7;

/*
* 대리 객체 은폐
* 클라이언트가 객체의 대리 클래스를 호출할 땐
* 대리 클래스를 감추는 메서드를 서버에 작성하자
*/
public class HideDelegateV2 {

    public static void main(String[] args) {
        Person2 john = new Person2();

        //존의 팀의 팀장을 알아내는 코드
        //이런 의존성을 줄이기위해서 위임 메서드를 작성하는 것이다.(대리 객체 은폐)
        Person2 manager = john.getManager();
    }

}

class Person2{

    Department2 _department;

    public Person2 getManager(){ //위임 메서드 작성(대리 객체 은폐)
        return _department.getManager();
    }

    public Department2 getDepartment(){
        return _department;
    }

    public void setDepartment(Department2 arg){
        _department = arg;
    }

}

class Department2{

    private String _chargeCode;
    private Person2 _manager;

    public Department2(Person2 manager) {
        manager = _manager;
    }

    public Person2 getManager() {
        return _manager;
    }


}


