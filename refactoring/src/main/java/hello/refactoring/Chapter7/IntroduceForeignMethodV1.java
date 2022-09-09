package hello.refactoring.Chapter7;

import java.util.Date;

/*
* 외래 클래스에 메서드 추가
* 현재 클래스에 메서드를 추가해야하는데 그 클래스를 수정할 수 없을 땐
* 클라이언트 클래스 안에 클래스의 인스턴스를 첫 번째 인자로 받는 메서드를 작성하자
* */
public class IntroduceForeignMethodV1 {

    PreviousEnd previousEnd = new PreviousEnd();
    Date newStart = new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getYear()+1);

    class PreviousEnd{

        int year;
        int month;
        int date;

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDate() {
            return date;
        }

    }
}
