package hello.refactoring.Chapter8.ReplaceSubclassWithFieldsV2;

/*
* 하위클래스를 필드로 전환
* 여러 하위클래스가 상수 데이터를 반환하는 메서드만 다룰 땐
* 각 하위클래스의 메서드를 상위클래스 필드로 전환하고 하위클래스는 전부 삭제하자
* */
abstract class Person {
    private final boolean _isMale;
    private final char _code;

    public Person(boolean _isMale, char _code) {
        this._isMale = _isMale;
        this._code = _code;
    }

    static Person createMale(){
        return new Male(true,'M');
    }

    static Person createFemale(){
        return new Female(false,'F');
    }

}
