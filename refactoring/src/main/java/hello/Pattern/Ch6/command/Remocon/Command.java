package hello.Pattern.Ch6.command.Remocon;

/*
* 커맨드 패턴
* 커맨드 패턴을 사용하면 요청 내역을 객체로 캡슐화해서
* 객체를 서로 다른 요청 내역에 따라 매개변수화할 수 있습니다.
* 이러면 요청을 큐에 저장하거나 로그로 기록하거나 작업 취소 기능을 사용할 수 있습니다.
* */
public interface Command {

    public void execute();

}
