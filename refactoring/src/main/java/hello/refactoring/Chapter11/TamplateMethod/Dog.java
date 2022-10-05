package hello.refactoring.Chapter11.TamplateMethod;

public class Dog extends Animal{
    @Override
    int getKind() {
        return 5202;
    }

    @Override
    String getFood() {
        return "사료료료";
    }

    @Override
    String getSound() {
        return "와로왈왈~~~";
    }
}
