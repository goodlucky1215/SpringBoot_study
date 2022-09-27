package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV1;

abstract class EmployeeType {
    abstract int getTypeCode();

    public static final int ENGINEER = 1;
    public static final int SALESMAN = 2;
    public static final int MANAGER = 3;
}
