package hello.refactoring.Chapter6;

/*
* 직관적 임시변수 사용
* */
public class IntroduceExplainingVariableV2 {

    public void price(){
        String platform = "Dfskfowekr";
        String browser = "Dfskfowekr";

        //수식이 복잡할 경우 직관적 임시변수 사용하기
        //임시변수는 남발해서는 안된다.
        //임시변수 사용 전에 더 좋은 방법이 잆는지 생각해봐야한다.
        //지역변수로 인해서 메서드 추출을 적용하기 힘들 때는 어쩔 수 없이 "직관적 임시변수 기법"을 사용
        final boolean isMacOs = platform.toUpperCase().indexOf("MAC")>-1;
        final boolean isIEBrowser = platform.toUpperCase().indexOf("MAC")>-1;
        
        if(isMacOs && isIEBrowser) {
            //기능코드
        }
    }
    
}
