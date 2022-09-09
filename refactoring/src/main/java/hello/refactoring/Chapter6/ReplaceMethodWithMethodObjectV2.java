package hello.refactoring.Chapter6;

/*
* 메서드를 메서드 객체로 전환
* */
public class ReplaceMethodWithMethodObjectV2 {

    // 지역변수 때문에 메서드 추출을 적용할 수 없는 긴 메서드가 있으면
    //그 메서드 자체를 객체로 전환해서 모든 지역변수를 객체의 필드로 만드는 방법
    //그리고 그 메서드 객체 안의 여러 메서드로 쪼개면 된다.
    class Account{
        int gamma(int inputVal, int quantity, int yearToDate){
            return new Gamma(this, inputVal, quantity, yearToDate).compute();
        }
    }


    //방법 순서
    // 1. 전환할 메서드의 이름과 같은 새 클래스를 생성 => class Gamma
    // 2. 원본 메서드가 들어 있던 객체를 나타내느 final필드를 추가하자  => private final Account _account;
    // 3. 새 클래스에 원본 객체와 각 매개변수를 받는 생성자 메서드를 생성하자. => Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg)
    // 4. 원본 메서드 안에 있더 로직들을 새로운 메서드로 만들어서 작성 => compute()
    // 5. 컴파일 실시
    // 6. 원본 메서드에 새 객체를 생성하고 해당 메서드를 호출하자 => return new Gamma(this, inputVal, quantity, yearToDate).compute();
    class Gamma{


        //필드명일때는 앞에 언더바(_)를 붙여서 구분을 쉽게하자.
        private final Account _account;
        private int _inputVal;
        private int _quantity;
        private int _yearToDate;
        private int _importantValue1;
        private int _importantValue2;
        private int _importantValue3;

        Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
            this._account = source;
            this._inputVal = inputValArg;
            this._quantity = quantityArg;
            this._yearToDate = yearToDateArg;
        }

        int compute(){
            _importantValue1 = (_inputVal * _quantity) + 123123;
            _importantValue2 = (_inputVal * _yearToDate) + 100;
            importantThing();
            _importantValue3 = _importantValue2 * 7;

            return _importantValue3 - 2 * _importantValue1;
        }

        private int importantThing() {
            if((_yearToDate - _importantValue1)>100) _importantValue2 -= 20;
            return _importantValue2;
        }
    }
}
