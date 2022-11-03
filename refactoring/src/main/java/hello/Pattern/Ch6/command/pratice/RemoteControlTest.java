package hello.Pattern.Ch6.command.pratice;

public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl(); //인보커 : 사용자가 리모콘을 듬
        Light light = new Light(); //리시버 : 거기엔 버튼 on, off기능이 있음
        LightOnCommand lightOn = new LightOnCommand(light); //커맨드 : 그 기능을 실행해주는 역할을 함

        remote.setCommand(lightOn); //커맨드를 인보커에게 전달 : 사용자 리모콘에 기능실행 역할을 넣어줌
        remote.buttonWasPressed();//실행 : 사용자가 버튼을 누름 기능이 실행됨.
    }
}
