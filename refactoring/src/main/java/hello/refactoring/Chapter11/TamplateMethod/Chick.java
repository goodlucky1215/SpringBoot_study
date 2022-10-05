package hello.refactoring.Chapter11.TamplateMethod;

public class Chick extends Animal{
    @Override
    int getKind() {
        return 120;
    }

    @Override
    String getFood() {
        return "모이모이";
    }

    @Override
    String getSound() {
        return "삐약~~뺙뺙";
    }
}
