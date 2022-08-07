package hello.aop.member;

import hello.aop.member.annotation.ClassAop;
import hello.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@ClassAop
@Component
public class MemberSerivceImpl implements MemberSerivce {

    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param) {
        return "ok";
    }
}
