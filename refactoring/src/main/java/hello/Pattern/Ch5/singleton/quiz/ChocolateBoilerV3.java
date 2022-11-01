package hello.Pattern.Ch5.singleton.quiz;

/*
* 싱글턴 패턴 사용 후 _ 멀티스레드 해결방법1. synchronized
* synchronized를 사용하면 멀티스레딩 문제 해결 가능
* => but 속도가 100배 저하
* */
public class ChocolateBoilerV3 {

    private boolean empty;
    private boolean boiled;


    private static ChocolateBoilerV3 chocolateBoiler;

    public static synchronized ChocolateBoilerV3 getInstance(){
        if(chocolateBoiler==null){
            chocolateBoiler = new ChocolateBoilerV3();
        }
        return chocolateBoiler;
    }

    private ChocolateBoilerV3(){
        empty = true;
        boiled = false;
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

    //보일러가 빙어 있을 때만 재료를 넣는다.
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
