package hello.Pattern.Ch6.command.Remocon;

public class RemoteLoaderRamda {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light();
        Light kitchenLight = new Light();
        Stereo stereo = new Stereo();

        //람다 표현식으로 사용할 수 있지만,
        //command 인터페이스에 추상메소드가 하나일 때만 가능하다는 점을 유의해야한다.
        /*
        remoteControl.setCommand(0,() -> livingRoomLight.on(), //excute에 이 메서드가 할당됨
                ()-> livingRoomLight.off()); //excute()메소드에 livingRoomLight.off()가 할당된다.
        remoteControl.setCommand(1,() -> kitchenLight.on(),
                ()-> kitchenLight.off());
        remoteControl.setCommand(2,() -> stereo.on(),
                ()-> stereo.setVolume(5));

         */



        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(2);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
    }
}
