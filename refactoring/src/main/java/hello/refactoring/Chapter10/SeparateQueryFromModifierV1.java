package hello.refactoring.Chapter10;

/*
* 상태 변경 메서드와 값 반환 메서드를 분리
* 값 반환 기능과 객체 상태 변경 기능이 한 메서드에 들어 있을 땐
* 질의 메서드와 변경 메서드로 분리하자.
* */
public class SeparateQueryFromModifierV1 {
   //보안 시스템에서 침입자의 이름을 알려주고, 침입자가 둘 이상이어도 경고가 한 번만 송신되는 개발이라는 가정하이다.
    String foundMiscreant(String[] people){
        for(int i=0;i<people.length;i++){
            if(people[i].equals("Don")){
                sendAlert();
                return "Don";
            }
            if(people[i].equals("Jhon")){
                sendAlert();
                return "Jhon";
            }
        }
        return "";
    }

    private void sendAlert() {
    }

    void checkSecurity(String[] people){
        String found = foundMiscreant(people);
    }
}
