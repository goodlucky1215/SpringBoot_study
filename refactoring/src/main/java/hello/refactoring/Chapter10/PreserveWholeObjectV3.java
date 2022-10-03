package hello.refactoring.Chapter10;

/**
 * 객체를 통째로 전달
 * 객체에서 가져온 여러 값을 메서드 호출에서 매개변수로 전달할 땐
 * 그 객체를 통째로 전달하게 수정하자
 */
public class PreserveWholeObjectV3 {

    boolean withinPlan(){
        return HeatingPlan(new PreserveWholeObject());
    }

    //아예 통체로 객체를 전달하는 방법
    private boolean HeatingPlan(PreserveWholeObject preserveWholeObject) {
        return preserveWholeObject.HeatingPlan();
    }

}


