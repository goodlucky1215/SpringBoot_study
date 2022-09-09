package hello.refactoring.Chapter6;

/*
* 매개변수로의 값 대입 제거
* */
public class RemoveAssignmentsToParametersV1 {


    int disount(int inputVal, int quantity, int yearToDate){
        // 매개변수로 들어온 inputVal을 다른 객체 참조로 변경해서는 안된다.
        if(inputVal > 50) inputVal -= 2;
        if(quantity > 100) inputVal -= 5;
        if(yearToDate> 1200) inputVal -= 12;
        return inputVal;
    }

}
