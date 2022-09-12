package hello.refactoring.Chapter8;

/*
* 베열을 객체로 전환
* 배열을 구성하는 원소가 다양한 의미를 가질 때는 객체로 전환하자.
* */
public class ReplaceArrayWithObjectV1 {

    public static void main(String[] args) {
        String[] row = new String[3];
        row[0] = "리버풀"; //팀이름
        row[1] = "14"; //이긴횟수
        row[2] = "3"; //진횟수
    }
}
