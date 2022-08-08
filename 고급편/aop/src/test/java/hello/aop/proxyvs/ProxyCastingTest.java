package hello.aop.proxyvs;

import hello.aop.member.MemberSerivce;
import hello.aop.member.MemberSerivceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy(){
        MemberSerivce target = new MemberSerivceImpl();
        //MemberSerivceImpl target = new MemberSerivceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(false); //JDK동적프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberSerivce memberSerivceProxy = (MemberSerivce) proxyFactory.getProxy();

        //JDK동적프록시를 구현클래스로 캐스팅 시도 실패, ClassCastException 예외발생
        MemberSerivceImpl castingMemberService = (MemberSerivceImpl) memberSerivceProxy;
        //MemberSerivceImpl castingMemberService = (MemberSerivceImpl) proxyFactory.getProxy();
    }

    @Test
    void cglibProxy(){
        MemberSerivce target = new MemberSerivceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); //CGLIB동적프록시

        //프록시를 인터페이스로 캐스팅 성공
        MemberSerivce memberSerivceProxy = (MemberSerivce) proxyFactory.getProxy();

        //JDK동적프록시를 구현클래스로 캐스팅 성공
        MemberSerivceImpl castingMemberService = (MemberSerivceImpl) memberSerivceProxy;
        //MemberSerivceImpl castingMemberService = (MemberSerivceImpl) proxyFactory.getProxy();
    }
}
