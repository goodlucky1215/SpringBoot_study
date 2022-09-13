package hello.refactoring.Chapter8.ReplaceTypeCodeeWithSubclasses;

public class TestC {

    public static void main(String[] args) {
        Employee employee = Employee.create(Employee.ENCINEER);
        employee.getType();
    }
}
