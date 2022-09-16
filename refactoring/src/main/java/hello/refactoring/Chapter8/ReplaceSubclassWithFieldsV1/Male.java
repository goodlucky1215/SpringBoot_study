package hello.refactoring.Chapter8.ReplaceSubclassWithFieldsV1;

public class Male extends Person{
    @Override
    boolean isMale() {
        return true;
    }

    @Override
    char getCode() {
        return 'M';
    }
}
