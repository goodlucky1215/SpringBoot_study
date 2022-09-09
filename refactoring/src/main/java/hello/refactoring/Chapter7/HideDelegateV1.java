package hello.refactoring.Chapter7;

/*
* 대리 객체 은폐
* 클라이언트가 객체의 대리 클래스를 호출할 땐
* 대리 클래스를 감추는 메서드를 서버에 작성하자
*/
public class HideDelegateV1 {

    public static void main(String[] args) {
        Person1 john = new Person1();

        //존의 팀의 팀장을 알아내는 코드
        //Department()의 원리를 알수 있고, Department()클래스의 기능이 팀장 정보를 지속적으로 알아내는 것임도 알 수있다.
        //이런 의존성을 줄이기위해서 위임 메서드를 작성하는 것이다.(대리 객체 은폐)
        Person1 manager = john.getDepartment().getManager();

    }

}

    class Person1{

        Department1 _department;

        public Department1 getDepartment(){
            return _department;
        }

        public void setDepartment(Department1 arg){
            _department = arg;
        }

    }

    class Department1{

        private String _chargeCode;
        private Person1 _manager;

        public Department1(Person1 manager) {
            manager = _manager;
        }

        public Person1 getManager() {
            return _manager;
        }


    }

