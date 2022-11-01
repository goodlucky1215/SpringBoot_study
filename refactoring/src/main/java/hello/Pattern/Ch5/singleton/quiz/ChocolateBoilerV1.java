package hello.Pattern.Ch5.singleton.quiz;

/*
* 싱글턴 패턴 사용 전
* 만약 ChocolateBoilerV1가 여러개 생성되서
* 하나의 초콜릿 공장에서 같이 돌아가게되면
* 갓 생성된 것은 보일러가 비어있는줄알고, 재료를 넣고 (fill())
* 원래 생성된 보일러가 만약 끓고 있는 상태라면 (boil())
* 기계가 엉키게 되서 엉망이 될 수 있다.
* */
public class ChocolateBoilerV1 {

    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerV1(){
        empty = true;
        boiled = false;
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

    //보일러가 비어 있을 때만 재료를 넣는다.
    public void fill(){
        if(isEmpty()){
            empty = false;
            boiled = false;
        }
    }
    //보일러가 차있고, 끓여진 상태면 다음 단계로 넘긴다.
    //보일러는 다 비우고 나면 true로 변경
    public void drain(){
        if(!isEmpty() && isBoiled()){
            empty = true;
        }
    }

    public void boil(){
        //재료를 다 넣고 아직 안끓인 상태면 끓임
        if(!isEmpty() && !isBoiled()){
            boiled = true; //끓이는 중이니 true로 변경
        }
    }
}
