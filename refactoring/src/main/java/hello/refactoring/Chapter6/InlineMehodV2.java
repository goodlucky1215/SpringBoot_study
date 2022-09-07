package hello.refactoring.Chapter6;

/*
* 메서드 내용 직접 삽입
* */
public class InlineMehodV2 {

    // 메서드 기능이 너무 단순해서 메서드명만 봐도 너무 뻔할 땐
    // 그 메서드의 기능을 호출하는 메서드에 넣어버리고 그 메서드는 삭제하자. => 지나치게 쪼개지 않기
    int getRating(int _number){
        return _number>5 ? 2 : 1;
    }

    // 간단한 수식을 대입받는 임시변수로 인해서 리팩토링 적용이 힘들 땐, (ExtractMethodV1의 지역변수)
    // 그 임시변수를 참조하는 부분을 전부 수식으로 치환하자.
    boolean inlineTemp(){
        return (new Order().getBasePrice() > 1000);
    }
}
