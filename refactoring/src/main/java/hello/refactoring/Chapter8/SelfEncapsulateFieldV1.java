package hello.refactoring.Chapter8;

/*
* 필드 자체 캡슐화
* 필드에 직접 접근하던 중 그 필도로의 결합에 문제가 생길 땐
* 그 필드용 읽기/쓰기 메서드를 작성해서 두 메서드를 통해서만 필드에 접근하게 만들자.
*
* 간접접근방식과 직접접근방식의 사용 방식의 주장은 팽팽하다.
* 간접접근방식은 하위클래스가 메서드에 해당 정보를 가져오는 방식을 재정의 할 수 있으며,
* 데이터 관리(속성 초기화가 생성 시점이 아닌 사용 시점을 미뤄진다.)가 더 유연해진다는 장점이다.
* 직접접근방식은 코드를 알아보기 쉽다는게 장점이다.
*
* 평소에는 직접 접근 방식을 사용하다가
* 하위클래스에서 계산된 값을 재정의해야 할 때는 "필드 자체 캡슐화"(간접 접근 방식)을 사용한다.
* */
public class SelfEncapsulateFieldV1 {

    //예제1//////////////////////////////////////////////////
    private int _low, _high;
    boolean includes(int arg){
        return arg >= _low && arg <= _high;
    }

    //예제2//////////////////////////////////////////////////
    class InRange{

        private int _low, _high;

        InRange(int low, int high) {
            this._low = low;
            this._high = high;
        }

        boolean includes(int arg){
            return arg >= _low && arg <= _high;
        }

        void grow(int factor){
            _high = _high * factor; //_high 계산 된 값으로 재정의함.
        }
    }
}
