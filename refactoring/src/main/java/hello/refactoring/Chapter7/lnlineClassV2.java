package hello.refactoring.Chapter7;

/*
* 클래스 내용 직접 삽입
* */
public class lnlineClassV2 {


    class Person{

        private TelephoneNumber _officeTelephone = new TelephoneNumber();

        private String _name;
        private String _areaCode;
        private String _number;


        public String getName() {
            return _name;
        }

        public String getTelephoneNumber() {
            return ("("+_areaCode+") "+_number);
        }

        public String getNumber() {
            return _number;
        }

        public void setNumber(String number) {
            this._number = number;
        }



        public String getAreaCode() {
            return _areaCode;
        }

        public void setAreaCode(String arg) {
            this._areaCode = arg;
        }


    }

    //ExtractClass와는 반대로 클래스 내용에 직접 삽입을 하는 방식

    class TelephoneNumber{


    }



}


