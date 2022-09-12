package hello.refactoring.Chapter8;

/*
* 분류 부호를 클래스로 전환 V2는 패키지로 만듬.
* */
public class ReplaceTypeCodeWithClassV1 {

    class Person{
        public static final int O  = 0;
        public static final int A  = 1;
        public static final int B  = 2;
        public static final int AB = 3;

        private int _bloodGroup;

        public Person(int bloodGroup){
            _bloodGroup = bloodGroup;
        }
        public int getBloodGroup() {
            return _bloodGroup;
        }

        public void setBloodGroup(int bloodGroup) {
            this._bloodGroup = bloodGroup;
        }
    }

}
