package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV2;

public class Manager extends EmployeeType {
    int payAmount(Employee emp){
        return 30;
    }
}
