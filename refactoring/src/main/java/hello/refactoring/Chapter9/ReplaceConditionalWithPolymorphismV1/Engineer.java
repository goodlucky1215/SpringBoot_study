package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV1;

public class Engineer extends EmployeeType{
    int getTypeCode() {
        return ENGINEER;
    }
}
