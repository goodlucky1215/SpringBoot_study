package hello.refactoring.Chapter8.ReplaceTypeCodeWitStateOrStrategyV2;

public class Teacers extends EmployeeType {

    @Override
    int getTypeCode() {
        return TEACHERS;
    }
}
