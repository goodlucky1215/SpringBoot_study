package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV2;

public class Engineer extends EmployeeType {
    int payAmount(Employee emp){
        return 45;
    }
}
