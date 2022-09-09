package hello.refactoring.Chapter7;

/*
* 과잉 중개 메서드 제거
* 클래스에 자잘한 위임이 너무 많을 땐
* 대리 객체를 클라이언트가 직접 호출하게 하자.
* */
public class RemoveMiddleManV1 {

    public static void main(String[] args) {
        RMM_Person1 john = new RMM_Person1();

        //존의 팀의 팀장을 알아내는 코드
        //위임 메서드가 너무 많아지면 메서드가 많아진다. (과잉 중개 제거)
        RMM_Person1 manager = john.getManager();
    }

}

class RMM_Person1{

    RMM_Department1 _department;

    public RMM_Person1 getManager(){ //위임 메서드 작성(대리 객체 은폐)
        return _department.getManager();
    } //위임 메서드

    public RMM_Department1 getDepartment(){
        return _department;
    }

    public void setDepartment(RMM_Department1 arg){
        _department = arg;
    }
}

class RMM_Department1{

    private RMM_Person1 _manager;

    public RMM_Department1(RMM_Person1 manager) {
        manager = _manager;
    }

    public RMM_Person1 getManager() {
        return _manager;
    }


}
