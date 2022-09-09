package hello.refactoring.Chapter7;

import java.util.Date;

/*
* 국소적 상속확장 클래스 사용
* 사용 중인 서버 클래스에 여러 개의 메서드를 추가해야 하는데 클래스를 수정할 수 없을 땐
* 새 클래스를 작성하고 그 안에 필요한 여러 개의 메서드를 작성하자.
* 이 상속확장 클래스를 원본 클래스의 "하위클래스나 래퍼 클래스"로 만들자.
*
* 작가는 하위클래스를 선호하는 편이다.
* 작업량이 적기 때문이다.
* 문제점은 객체를 생성함과 동시에 하위클래스를 만들어야한다는 점이다.
* */
public class IntroduceLocalExtensionV1 {

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

    Date nextDay() {
        return new Date(getYear(), getMonth(), getDate() + 1);
    }

}

class MFDateSub extends Date {

    public MFDateSub(String dateString){
        super(dateString);
    }

    public MFDateSub(Date arg){
        super(arg.getTime());
    }

}
