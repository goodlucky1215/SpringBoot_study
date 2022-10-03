package hello.refactoring.Chapter10;

/**
 * 객체를 통째로 전달
 * 객체에서 가져온 여러 값을 메서드 호출에서 매개변수로 전달할 땐
 * 그 객체를 통째로 전달하게 수정하자
 */
public class PreserveWholeObjectV2 {

    boolean withinPlan(){
        return HeatingPlan(new PreserveWholeObject());
    }

    private boolean HeatingPlan(PreserveWholeObject preserveWholeObject) {
        return (preserveWholeObject._low >= 10 && preserveWholeObject._high <= 30);
    }

}


