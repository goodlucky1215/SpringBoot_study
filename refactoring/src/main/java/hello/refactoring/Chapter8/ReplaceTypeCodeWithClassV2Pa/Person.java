package hello.refactoring.Chapter8.ReplaceTypeCodeWithClassV2Pa;

public class Person {


    private BloodGroup _bloodGroup;

    public BloodGroup getBloodGroup() {
        return _bloodGroup;
    }

    public void setBloodGroup(BloodGroup _bloodGroup) {
        this._bloodGroup = _bloodGroup;
    }

    public Person(BloodGroup bloodGroup) {
        _bloodGroup = bloodGroup;
    }
}
