package hello.Pattern.Ch1.Strategy.easy;

public class TestAnimal {

    public static void main(String[] args) {
        Animal puppy = new Animal();
        //이렇게 실행 중에 알맞는 동물로 선택해서 사용함.
        puppy.setSoundStrategy(new DogSound());
        puppy.goSound();
    }
}
