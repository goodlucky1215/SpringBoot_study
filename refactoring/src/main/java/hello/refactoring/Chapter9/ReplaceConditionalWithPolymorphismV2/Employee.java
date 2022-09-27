package hello.refactoring.Chapter9.ReplaceConditionalWithPolymorphismV2;

public class Employee {
    private EmployeeType _type;

    public void setType(EmployeeType _type) {
        this._type = _type;
    }
    int payAmount(){
        return _type.payAmount(this);
    }
}
