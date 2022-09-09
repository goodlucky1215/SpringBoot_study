package hello.refactoring.Chapter7;

/*
* 클래스 내용 직접 삽입
* 클래스에 기능이 너무 적을 때,
* 클래스의 모든 기능을 다른 클래스로 합쳐 넣고 원래 클래스는 삭제하자.
* */
public class lnlineClassV1 {


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

    class TelephoneNumber{

        private String _areaCode;
        private String _number;

        public String getNumber() {
            return _number;
        }

        public void setNumber(String number) {
            this._number = number;
        }


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


