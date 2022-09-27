package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV1;

public class Salesman extends EmployeeType{
    int getTypeCode() {
        return SALESMAN;
    }
}
