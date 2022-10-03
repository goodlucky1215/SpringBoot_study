package hello.refactoring.Chapter10.RemoveSettingMethodV3;

/*
* 쓰기 메서드 제거
* 생성할 때 지정한 필드 값이 절대로 변경되지 말아야 할 땐
* 그 필드를 설정하는 모든 쓰기 메서드를 삭제하자.
* */
public class RemoveSettingMethodV1 {

    private String _id;

    public void setId(String _id) {
        this._id = _id;
    }
}
