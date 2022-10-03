package hello.refactoring.Chapter10.IntroduceParameterObjectV2;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
/*
 * 매개변수 세트를 객체로 전환
 * 여러 개의 매개변수가 항상 세트로 붙어 다닐 땐
 * 그 매개변수들을 객체로 바꾼다.
 * */
public class Account {

    private Vector _entries;

    double getFlowBetween(DateRange range){
        double result  = 0;
        Enumeration e = _entries.elements();
        while(e.hasMoreElements()){
            Entry each = (Entry) e.nextElement();
            if(range.includes(each.getChargeDate())){
                result += each.getValue();
            }
        }
        return  result;
    }
}
