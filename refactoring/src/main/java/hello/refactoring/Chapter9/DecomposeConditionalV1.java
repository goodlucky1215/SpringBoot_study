package hello.refactoring.Chapter9;

import java.util.Date;

/*
* 조건문 쪼개기
* */
public class DecomposeConditionalV1 {
    Date SUMMER_START, SUMMER_END;
    int _summerRate,_winterRate;
    //복잡한 조건문
    void condition(){
        Date date = new Date();
        int charge,quantity = 0;
        if(date.before(SUMMER_START) || date.after(SUMMER_END)) {
            charge = quantity + _summerRate * _winterRate;
        }else charge = quantity + _summerRate;
    }
}

