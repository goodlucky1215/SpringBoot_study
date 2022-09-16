package hello.refactoring.Chapter8.ReplaceSubclassWithFieldsV1;

public class Female extends Person{
    @Override
    boolean isMale() {
        return false;
    }

    @Override
    char getCode() {
        return 'F';
    }
}
