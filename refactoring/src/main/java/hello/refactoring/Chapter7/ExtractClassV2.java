package hello.refactoring.Chapter7;

/*
* 클래스 추출
* 두 클래스가 처리해야 할 기능이 하나의 클래스에 들어 있을 땐
* 새 클래스를 만들고 기존 클래스의 관련 필드와 메서드를 새 클래스로 옮기자
*
* 클새스는 두세 가지의 명확한 기능을 담당해야 한다.
* 실제로 클래스는 시간이 갈수록 방대해진다.
* 클래스의 어느 부분을 분리할지 궁리해서 떼어내야한다.
* => 데이터의 일부분과 메서드의 일부분이 한 덩어리이거나, 주로 함께 변화하거나 서로 유난히 의존적인 데이터의 일부분도 클래스로 떼어내기 좋다.
* => 판단하는 좋은 방법은 데이터나 메서드를 하나 제거하면 어떻게 될지, 다른 필드와 메서드를 추가하는 건 합리적이지 않은지 자문해보는 것이다.
* */
public class ExtractClassV2 {

    class Person{

        private TelephoneNumber _officeTelephone = new TelephoneNumber();

        private String _name;



        public String getName() {
            return _name;
        }

        public String getTelephoneNumber() {
            return _officeTelephone.getTelephoneNumber();
        }


    }


    //각 클래스를 검사해서 인터페이스를 줄이자. => 양방향 링크가 있다면 그것을 단방향으로 바꿀 수 있는지 알아보자.
    //여러 곳에서 클래스에 접근할 수 있게 할지 결정하기. 여러곳에서 접근할 수 있게 할 경우
    //새 클래스를 참조 객체나 변경불가 값 객체로서 공개할지 여부를 결정하자.
    class TelephoneNumber{

        //1. 필드 이동 실시 => 필드를 하나 옮길 때마다 컴파일과 테스트를 실시할 것
        private String _areaCode;
        private String _number;

        public String getNumber() {
            return _number;
        }

        public void setNumber(String number) {
            this._number = number;
        }

        //2. 메서드 이동 실시 => 메서드를 하나 옮길 때마다 컴파일과 테스트를 실시할 것
        public String getTelephoneNumber() {
            return ("("+_areaCode+") "+_number);
        }

        public String getAreaCode() {
            return _areaCode;
        }

        public void setAreaCode(String arg) {
            this._areaCode = arg;
        }

    }


}
