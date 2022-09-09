package hello.refactoring.Chapter7;

/*
* 과잉 중개 메서드 제거
* 클래스에 자잘한 위임이 너무 많을 땐
* 대리 객체를 클라이언트가 직접 호출하게 하자.
* */
public class RemoveMiddleManV2 {

    public static void main(String[] args) {
        RMM_Person2 john = new RMM_Person2();

        //존의 팀의 팀장을 알아내는 코드
        //위임 메서드 제거(과잉 중개 메서드 제거)
        RMM_Person2 manager = john.getDepartment().getManager();
    }

}

class RMM_Person2{

    RMM_Department2 _department;

    public RMM_Department2 getDepartment(){
        return _department;
    }

    public void setDepartment(RMM_Department2 arg){
        _department = arg;
    }
}

class RMM_Department2{

    private RMM_Person2 _manager;

    public RMM_Department2(RMM_Person2 manager) {
        manager = _manager;
    }

    public RMM_Person2 getManager() {
        return _manager;
    }


}
