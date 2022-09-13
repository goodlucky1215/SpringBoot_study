package hello.refactoring.Chapter8.ReplaceTypeCodeeWithSubclasses;

/*
 * 분류 부호를 하위클래스로 전환
 * 클래스 기능에 영향을 주는 변경불가 분류 부호가 있을 땐 분류 부호를 하위클래스로 만들자
 * 다형적인 기능이 수시로 변할 때 편리하다
 *
 * 생성자 메서드를 팩토리 메서드로 변경
 * */
public abstract class Employee {

    static Employee create(int type){
        switch (type){
            case ENCINEER:
                return new Enginner();
            case SALESMAN:
                return new Salesman();
            case TEACHERS:
                return new Teacers();
            default:
                throw new IllegalArgumentException("분류 부호가 잘 못 됨");
        }
    }

    abstract int getType();

    static final int ENCINEER = 0;
    static final int SALESMAN = 1;
    static final int TEACHERS = 2;

}
