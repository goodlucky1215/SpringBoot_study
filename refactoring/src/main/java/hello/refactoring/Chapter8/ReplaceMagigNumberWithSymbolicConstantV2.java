package hello.refactoring.Chapter8;

/*
* 특수 숫자를 기호 상수로 전환
* 특수 의미를 지닌 리터럴 숫자가 있을 땐
* 의미를 살린 이름의 상수로 작성 후 교체 하자.
* */
public class ReplaceMagigNumberWithSymbolicConstantV2 {

    static final double GRAVITATIONAL_CONSTANT = 9.81;
    double potential(double mass, double height){
        return mass * GRAVITATIONAL_CONSTANT * height;
    }
}
