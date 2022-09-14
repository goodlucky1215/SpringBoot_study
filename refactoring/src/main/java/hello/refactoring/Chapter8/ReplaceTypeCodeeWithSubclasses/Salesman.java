package hello.refactoring.Chapter8.ReplaceTypeCodeeWithSubclasses;

/*
 * 분류 부호를 하위클래스로 전환
 * 클래스 기능에 영향을 주는 변경불가 분류 부호가 있을 땐 분류 부호를 하위클래스로 만들자
 * 다형적인 기능이 수시로 변할 때 편리하다
 * */
public class Salesman extends Employee{

    @Override
    int getType() {
        System.out.println("나는 영업이야~~");
        return Employee.SALESMAN;
    }
}
