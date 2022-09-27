package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV2;

public class UseTest {

    public static void main(String[] args) {
        EmployeeType workman = new Engineer();
        Employee employee = new Employee();
        employee.setType(workman);
        System.out.println(employee.payAmount());
    }
}
