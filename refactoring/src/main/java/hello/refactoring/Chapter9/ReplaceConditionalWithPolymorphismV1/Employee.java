package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV1;

public class Employee {
    private EmployeeType _type;

    public void setType(EmployeeType _type) {
        this._type = _type;
    }

    public int getType() {
        return _type.getTypeCode();
    }

    int payAmount(){
        switch(getType()){
            case EmployeeType.ENGINEER:
                return 45;
            case EmployeeType.SALESMAN:
                return 30;
            case EmployeeType.MANAGER:
                return 40;
            default:
                throw new RuntimeException("없는 사원입니다.");
        }
    }
}
