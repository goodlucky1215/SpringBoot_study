package hello.Pattern.Ch5.singleton.quiz;

/*
* 싱글턴 패턴 사용 후_ 멀티스레드 해결방법3. DCL사용(Double-cheched Locking)
* DCL 사용하면 처음에만 동기화하고 나중에는 안해도 된니까
* 속도가 느려지지 않는다!!!
* volatile을 꼭 써줘야하는데 이는 자바5보다 낮은 버전에서 사용한다면 다른 싱글턴패턴을 사용해야한다.
* volatile이란? 매번 자바변수를 CPU캐시에 저장헤서 읽는게 아닌, 메인메모리에 저장하고 읽게다는 것을 명시
* */
public class ChocolateBoilerV5 {

    private boolean empty;
    private boolean boiled;


    private volatile static ChocolateBoilerV5 chocolateBoiler;

    public static ChocolateBoilerV5 getInstance(){
        if(chocolateBoiler==null){ //처음 만들때만 이 안으로 들어오니깐 (나중에는 이민 만들어져서 null이 아니니까)
            synchronized (ChocolateBoilerV5.class){ //처음에만 동기화가 일어나고
                if(chocolateBoiler==null){
                    chocolateBoiler = new ChocolateBoilerV5();
                }
            }
        }
        return chocolateBoiler;
    }

    private ChocolateBoilerV5(){
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
