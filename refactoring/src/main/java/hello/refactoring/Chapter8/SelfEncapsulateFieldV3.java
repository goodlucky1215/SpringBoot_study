package hello.refactoring.Chapter8;

/*
* 필드 자체 캡슐화
* 필드에 직접 접근하던 중 그 필도로의 결합에 문제가 생길 땐
* 그 필드용 읽기/쓰기 메서드를 작성해서 두 메서드를 통해서만 필드에 접근하게 만들자.
*
* */
public class SelfEncapsulateFieldV3 {

    private int _low, _high;
    boolean includes(int arg){
        return arg >= _low && arg <= _high;
    }

    class InRange{

        private int _low, _high;

        InRange(int low, int high) { //생성자 별도의 초기화 메서드
            this._low = low;
            this._high = high;
        }

        public int getLow() {
            return _low;
        }

        int getHigh() {
            return _high;
        }

        void setLow(int arg) {
            _low = arg;
        }

        void setHigh(int arg) {
            _high = arg;
        }

        boolean includes(int arg){
            return arg >= getLow() && arg <= getHigh();
        }

        void grow(int factor){
            setHigh(getHigh() * factor); //자체 캡슐화
        }
    }

    //쓰기 메서드에 초기화 시점과 다른 기능이 추가 됐을 수 있다고 전제할 때가 많다.
    //이럴 땐 생성자 별도의 초기화 메서드 직접 접근하는게 좋다.
    //InRange를 재정의하므로써 기능을 수정하지 않고 _cap을 계산해서 넣을 수 있다.
    class CappedRange extends InRange {

        private int _cap;

        CappedRange(int low, int high,int cap) {
            super(low, high); //생성자 별도의 초기화 메서드
            _cap = cap;
        }

        int getCap(){
            return _cap;
        }

        int getHigh(){
            return Math.min(super.getHigh(), getCap());
        }
    }
}
