package hello.refactoring.Chapter6;

import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Enumeration;

/*
*  메서드 추출
* */
public class ExtractMethodV1 {

    String _name = "나야나";

    void printOwing() {
        Enumeration e = (Enumeration) new ArrayList<Double>();
        double outstanding = 0.0;


        //배너 출력
        System.out.println("*************************************");
        System.out.println("********* 고객 외상 *********");
        System.out.println("*************************************");

        //외상액 계산
        while(e.hasMoreElements()){
             double each = (double) e.nextElement();
            outstanding += each;
        }

        //세부 내역 출력
        System.out.println("고객명: "+_name);
        System.out.println("외상액: "+outstanding);
    }

}
