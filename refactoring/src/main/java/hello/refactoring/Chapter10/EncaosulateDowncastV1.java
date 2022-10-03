package hello.refactoring.Chapter10;

/*
* 하향타입 변환을 캡슐화
* 메서드가 반환하는 객체를 호출 부분에서 하향 타입 변환해야 할 땐
* 하향 타입 변환 기능을 메서드 안으로 옮기자
*
* 되도록이면 항상 가장 구체적인 타입을 작성해야한다.
* */
public class EncaosulateDowncastV1 {
    String _value;
    Object lastReding(){
        return _value.substring(0);
    }

    public static void main(String[] args) {
        String result = (String) new EncaosulateDowncastV1().lastReding();
    }
}
