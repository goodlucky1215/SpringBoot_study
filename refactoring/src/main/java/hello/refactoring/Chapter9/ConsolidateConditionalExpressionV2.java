package hello.refactoring.Chapter9;

/*
* 중복 조건식 통합
* 여러 조건 검사식의 결과가 같을 땐
* 하나의 조건문으로 합친 후 메서드로 빼내자
*
* 조건문 코드를 합쳐야 하는 이유
* 1. 조건식을 합치면 여러 검사를 OR연산자로 연결해서 실제로 하나의 검사 수행을 표현해서 무엇을 검사하는지 더 확실히 이해 할 수 있다.
* 2. 이러한 조건식 통합 리팩토링 기법을 실시하면 메서드 추츨을 적용할 수 있는 기반이 마련된다.
* */
public class ConsolidateConditionalExpressionV2 {
    int _a = 123;
    int _b = 33;
    int disabilityAmount() {
        //1번 : 결과값이 같을 때는 OR로 하나의 조건문으로 바꾼다, 메소드로 코드를 쉽게 알아보도록 한다
        if(isNotNumber()) return 0;


        //2번 : 겹친 조건문은 AND로 하나의 조건문으로 바꾼다.
        if (_a==123 && _b==22) return 1;


        //3번 : 조건의 공통 실행 코드는 빼낸다.
        if(_a==10){
            _b = 10;
        }else {
            _b = 20;
        }
        send();


        return 11111;
    }

    boolean isNotNumber(){
        return (_a==0 || _a>100 || _a<-4);
    }

    void send(){
        System.out.println("값 추출");
    }

}
