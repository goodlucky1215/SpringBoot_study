package hello.refactoring.Chapter7;

import java.util.Date;

/*
* 외래 클래스에 메서드 추가
* 현재 클래스에 메서드를 추가해야하는데 그 클래스를 수정할 수 없을 땐
* 클라이언트 클래스 안에 클래스의 인스턴스를 첫 번째 인자로 받는 메서드를 작성하자
* */
public class IntroduceForeignMethodV2 {

    //새로운 기능을 추가해야하는 상황에서
    //원본 클래스를 수정할 수 있다면 그곳에 기능을 추가한다.
    //만약 원본 클래스를 수정할 수 없다면, 클라이언트 클래스 안에 작성해야 한다.
    //한 번만 사용한다면 이런식으로 코딩해도 괜찮지만 여러 곳에서 이 기능을 쓴다면?? 또는 추가 기능이 3개 이상이라면??
    //중복 코드가 발생하므로 "국소적 상속확장 클래스 사용"을 해야한다.(IntroduceLocalExtension을 참고)
    PreviousEnd previousEnd = new PreviousEnd();
    Date newStart = nextDay(previousEnd);

    private Date nextDay(PreviousEnd previousEnd) {
        return new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getYear() + 1);
    }

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
