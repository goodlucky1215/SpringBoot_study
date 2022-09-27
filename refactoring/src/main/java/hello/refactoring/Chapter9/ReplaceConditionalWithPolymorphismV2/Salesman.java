package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV2;

public class Salesman extends EmployeeType {
    int payAmount(Employee emp){
        return 40;
    }
}
