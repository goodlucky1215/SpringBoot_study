package hello.Pattern.Ch5.singleton.quiz;

/*
* 싱글턴 패턴 사용 후_ 멀티스레드 해결방법2. 인스턴스를 초기화
* 초기화할 때 인스턴스 생성하면, 문제 해결 가능
* JVM에서 하나뿐인 인스턴스가 생성된다.
* JVM에서 하나뿐인 인스턴스를 생성하기 전까지 그 어떤 스레드도
* ChocolateBoilerV4에 접근할 수는 없다.
* */
public class ChocolateBoilerV4 {

    private boolean empty;
    private boolean boiled;


    private static ChocolateBoilerV4 chocolateBoiler = new ChocolateBoilerV4();

    public static ChocolateBoilerV4 getInstance(){
        return chocolateBoiler;
    }

    private ChocolateBoilerV4(){
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
