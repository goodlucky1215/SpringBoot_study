package hello.refactoring.Chapter8.ReplaceTypeCodeWitStateOrStrategyV2;

abstract public class EmployeeType {
    abstract int getTypeCode();

    static final int ENCINEER = 0;
    static final int SALESMAN = 1;
    static final int TEACHERS = 2;

    static EmployeeType newType(int type){
        switch (type){
            case ENCINEER:
                return new Enginner();
            case SALESMAN:
                return new Salesman();
            case TEACHERS:
                return new Teacers();
            default:
                throw new IllegalArgumentException("사원 부호가 잘못됨");
        }
    }
}
