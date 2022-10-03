package hello.refactoring.Chapter6;

/*
* 1. 메서드 내용 직접 삽입
* 2. 임시변수 내용 직접 삽입
* */
public class InlineMehodV1 {

    //1.
    int getRating(int _number){
        return (moreThanFiveLateDeliveries(_number)) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries(int _number) {
        return _number>5;
    }


    //2.
    boolean inlineTemp(){
        double basePrice = new Order().getBasePrice();
        return (basePrice > 1000);
    }

}
