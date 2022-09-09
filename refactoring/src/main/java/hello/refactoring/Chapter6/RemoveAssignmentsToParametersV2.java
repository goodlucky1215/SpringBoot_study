package hello.refactoring.Chapter6;

/*
* 매개변수로의 값 대입 제거
* */
public class RemoveAssignmentsToParametersV2 {


    int disount(int inputVal, int quantity, int yearToDate){
        // 따로 임시변수를 만들어서 사용한다.
        int result = inputVal;
        if(inputVal > 50) result -= 2;
        if(quantity > 100) result -= 5;
        if(yearToDate> 1200) result -= 12;
        return result;
    }

}
