package hello.refactoring.Chapter10.RemoveSettingMethodV3;

/*
* 쓰기 메서드 제거
* 생성할 때 지정한 필드 값이 절대로 변경되지 말아야 할 땐
* 그 필드를 설정하는 모든 쓰기 메서드를 삭제하자.
* */
public class RemoveSettingMethodV2 {

    private final String _id; // final로 처음 정한 값에서 바꾸지 못하게 설정

    //이렇게 생성자에서만 초기에 접근할 수 있도록 만든다.
    RemoveSettingMethodV2(String _id) {
        this._id = _id;
    }
}
