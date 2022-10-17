package hello.Pattern.Ch1.Strategy.easy;

/*
* 전략패턴
* 실행 중에 알고리즘으르 선택할 수 있는 디자인 패턴
* 내가 원하는 클래스로 유연하게 변경해서 사용이 가능하다.
*
* 바뀌는 부분을 찾아서 바뀌지 않는 부분과 분리해야한다.
* */
public class Animal {

    //동물의 소리는 동물에따라 변경됨
    private SoundStrategy _soundStrategy;

    //그 동물 소리를 캡슐화, 고양이와 강아지가 내는 소리는 다르다. => 바뀌는 부분
    public void setSoundStrategy(SoundStrategy soundStrategy) {
        this._soundStrategy = soundStrategy;
    }

    public void goSound(){
        System.out.println(_soundStrategy.sound());
    }

    //강아지 고양이 모두 똑같이 걷는다 . => 바뀌지 않는 부분
    public void goWalk(){
        System.out.println("터벅 터벅");
    }


}
