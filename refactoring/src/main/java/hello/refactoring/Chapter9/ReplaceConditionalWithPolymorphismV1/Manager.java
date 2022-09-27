package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV1;

public class Manager extends EmployeeType{
    int getTypeCode() {
        return MANAGER;
    }
}
