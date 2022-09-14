package hello.refactoring.Chapter8.ReplaceTypeCodeWitStateOrStrategyV2;



public class Salesman extends EmployeeType {

    @Override
    int getTypeCode() {
        return SALESMAN;
    }
}
