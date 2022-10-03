package hello.refactoring.Chapter10;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/*
* 예외 처리를 테스트로 교체
* 호출 부분에 사전 검사 코드를 넣으면 될 상황인데
* 예외 통지를 사용했을 땐
* 호출 부분이 사전 검사를 실시하게 수정하자.
* */
public class ReokaceExceotionWithTestV1 {

    Stack _ava;

    void getResource(){
        try {
            List result = (List) _ava.peek();
        }catch (EmptyStackException e){
            List result = new ArrayList();
            System.out.println(e.toString());
        }
    }
}
