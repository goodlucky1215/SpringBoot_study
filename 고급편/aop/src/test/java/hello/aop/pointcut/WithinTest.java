package hello.aop.pointcut;

import hello.aop.member.MemberSerivceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class WithinTest {


    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException{
        helloMethod = MemberSerivceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void withinPackage(){
        // public java.lang.String hello.aop.member.MemberSerivceImpl.hello(java.lang.String)
        pointcut.setExpression("within(hello.aop.member.MemberSerivceImpl)");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isTrue();
    }

    @Test
    void withinPackage1(){
        // hello.aop. => 해당 패키지의 클래스만 가능
        pointcut.setExpression("within(hello.aop.*)");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isTrue();
    }

    @Test
    void withinPackage2(){
        // hello.aop.. => 하위 패키지 및 클래스 가능
        pointcut.setExpression("within(hello.aop..*)");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isTrue();
    }

    @Test
    void withinPackageSuperType(){
        pointcut.setExpression("within(hello.aop.member.MemberSerivce)"); //excution과는 다르게!!!! 부모클래스를 매치하지 못한다.
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isFalse();
    }
}
