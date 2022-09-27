package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV2;

abstract public class EmployeeType {
    abstract int payAmount(Employee emp);
}
