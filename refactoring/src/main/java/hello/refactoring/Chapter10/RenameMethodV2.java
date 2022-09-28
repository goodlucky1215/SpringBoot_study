package hello.refactoring.Chapter10;

/*
* 메서드명 변경
* 메서드명을 봐도 기능을 알 수 없을 땐
* 메서드명을 직관적인 이름으로 바꾸자
* */
public class RenameMethodV2 {
    String _officeAreaCode;
    String _officeNumber;
    public String getTelephoneNumber(){
        return getOfficeTelephoneNumber(); //1. 새 메서드 호출로 바꾼다.
     }

    public String getOfficeTelephoneNumber(){ //2. 잘 동작하는지 확인한다.
        return _officeAreaCode+"-"+_officeNumber;
    }

    //3. 잘 동작하면 원래 메서드인 getTelephoneNumber()을 없얘고, 교체해서 사용한다.
}
