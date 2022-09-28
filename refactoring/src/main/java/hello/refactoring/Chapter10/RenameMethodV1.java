package hello.refactoring.Chapter10;

/*
* 메서드명 변경
* 메서드명을 봐도 기능을 알 수 없을 땐
* 메서드명을 직관적인 이름으로 바꾸자
* */
public class RenameMethodV1 {
    String _officeAreaCode;
    String _officeNumber;
    public String getTelephoneNumber(){
        return _officeAreaCode+"-"+_officeNumber;
    }
}
