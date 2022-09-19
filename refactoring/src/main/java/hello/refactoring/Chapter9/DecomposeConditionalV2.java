package hello.refactoring.Chapter9;

import java.util.Date;

/*
* 조건문 쪼개기
* 복잡한 조건문은 안 부분을 메서드로 빼내자
* */
public class DecomposeConditionalV2 {
    Date SUMMER_START, SUMMER_END;
    int _summerRate,_winterRate;
    //복잡한 조건문은 안 부분을 메서드로 빼내자
    void condition(){
        Date date = new Date();
        int charge,quantity = 0;
        if(notSummer(date)) {
            charge = winterCharge(quantity);
        }else charge = summerCharge(quantity);
    }

    boolean notSummer(Date date){
        return date.before(SUMMER_START) || date.after(SUMMER_END);
    }

    private int summerCharge(int quantity){
        return quantity + _summerRate;
    }

    private int winterCharge(int quantity){
        return quantity + _summerRate * _winterRate;
    }
}
