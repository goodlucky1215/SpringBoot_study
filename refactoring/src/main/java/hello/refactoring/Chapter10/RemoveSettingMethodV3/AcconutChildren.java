package hello.refactoring.Chapter10.RemoveSettingMethodV3;

public class AcconutChildren extends Account{

    //하위클래스가 상위클래스의 private변수를 초기화하는 문제일 경우다.
    AcconutChildren(String id) {
        //setId(_id); set을 써서도 안되고,
        //_id = "Sdf";  private변수인 _id에 직접 접근할 수 없으므로,
        super(id); // 상위 클래스 생성자를 가져온다.
    }
}
