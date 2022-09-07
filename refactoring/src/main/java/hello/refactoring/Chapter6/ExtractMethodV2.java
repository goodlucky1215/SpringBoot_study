package hello.refactoring.Chapter6;

import java.util.ArrayList;
import java.util.Enumeration;

/*
*  리팩토링_마틴 파울러
*  chapter6 : 메서드 정리
* */
public class ExtractMethodV2 {

    String _name = "나야나";

    void printOwing(double previousAmount) {

        //1번. 메소드 추출
        printBanner();

        //3. 계산 코드 밖으로 빼기
        double outstanding = getOutstanding(previousAmount*1.2);

        //2. 메소드 추출에 지역변수(즉 임시변수, outstanding)가 필요할 시 => 매개변수로 전달
        printDetails(outstanding);

    }

    private double getOutstanding(double previousAmount) {
        Enumeration e = (Enumeration) new ArrayList<Double>();
        double outstanding = previousAmount;
        //외상액 계산
        while(e.hasMoreElements()){
            double each = (double) e.nextElement();
            outstanding += each;
        }
        return outstanding;
    }

    public void printDetails(double outstanding) {
        //세부 내역 출력
        System.out.println("고객명: "+ _name);
        System.out.println("외상액: "+outstanding);
    }

    private void printBanner() {
        //배너 출력
        System.out.println("*************************************");
        System.out.println("********* 고객 외상 *********");
        System.out.println("*************************************");
    }

}
