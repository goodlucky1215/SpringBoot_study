package hello.refactoring.Chapter8;

/*
* 필드 자체 캡슐화
* 필드에 직접 접근하던 중 그 필도로의 결합에 문제가 생길 땐
* 그 필드용 읽기/쓰기 메서드를 작성해서 두 메서드를 통해서만 필드에 접근하게 만들자.
* */
public class SelfEncapsulateFieldV2 {

    private int _low, _high;
    boolean includes(int arg){
        return arg >= getLow() && arg <= getHigh();
    }

    public int getLow() {
        return _low;
    }

    public int getHigh() {
        return _high;
    }

    class InRange{

        private int _low, _high;

        public int getLow() {
            return _low;
        }

        public int getHigh() {
            return _high;
        }

        public void setLow(int arg) {
             _low = arg;
        }

        public void setHigh(int arg) {
             _high = arg;
        }

        boolean includes(int arg){
            return arg >= getLow() && arg <= getHigh();
        }

        void grow(int factor){
            setHigh(getHigh() * factor); //자체 캡슐화
        }
    }
}
