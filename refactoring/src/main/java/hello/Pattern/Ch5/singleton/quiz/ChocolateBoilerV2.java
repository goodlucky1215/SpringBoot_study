package hello.Pattern.Ch5.singleton.quiz;

/*
* 싱글턴 패턴 사용 후
* 여러 스레드 사용 시 문제가 생길 수 있다.
*                 스레드1                                          스레드2
* public static ChocolateBoilerV2 getInstance(){
*                                                       static ChocolateBoilerV2 getInstance(){
*   if(chocolateBoilerV2==null){
*                                                         if(chocolateBoilerV2==null){
*       chocolateBoilerV2 = new ChocolateBoilerV2();
*                                                          chocolateBoilerV2 = new ChocolateBoilerV2();
*
*
* => 이렇게 되면 스레드1과 스레드2에서 따른 객체가 생성이 된다.
*/
public class ChocolateBoilerV2 {

    private boolean empty;
    private boolean boiled;


    private static ChocolateBoilerV2 chocolateBoiler;

    public static ChocolateBoilerV2 getInstance(){
        if(chocolateBoiler==null){
            chocolateBoiler = new ChocolateBoilerV2();
        }
        return chocolateBoiler;
    }

    private ChocolateBoilerV2(){
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
