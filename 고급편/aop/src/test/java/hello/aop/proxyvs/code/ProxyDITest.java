package hello.aop.proxyvs.code;

import hello.aop.member.MemberSerivce;
import hello.aop.member.MemberSerivceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"}) //JDK동적프록시, 실패
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) //CGLIB, 성공
@Import(ProxyDIAspect.class)
public class ProxyDITest {

    @Autowired
    MemberSerivce memberSerivce;

    @Autowired
    MemberSerivceImpl memberSerivceImpl;

    @Test
    void go(){
        log.info("memberService class={}",memberSerivce.getClass());
        log.info("memberSerivceImpl class={}",memberSerivceImpl.getClass());
        memberSerivceImpl.hello("hellp");
    }

}
