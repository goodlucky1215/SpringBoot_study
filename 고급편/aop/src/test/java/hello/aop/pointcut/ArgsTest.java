package hello.aop.pointcut;

import hello.aop.member.MemberSerivceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ArgsTest {


    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberSerivceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void argsMatch1(){
        // public java.lang.String hello.aop.member.MemberSerivceImpl.hello(java.lang.String)
        pointcut.setExpression("args(String)");
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isTrue();
    }

    @Test
    void argsMatch2(){
        // public java.lang.String hello.aop.member.MemberSerivceImpl.hello(java.lang.String)
        pointcut.setExpression("args(java.io.Serializable)"); //String의 상위타입으로 args는 이를 허용(부모타입 허용)
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isTrue();
    }

    @Test
    void exactMatch(){
        // public java.lang.String hello.aop.member.MemberSerivceImpl.hello(java.lang.String)
        pointcut.setExpression("execution(* *(java.io.Serializable))"); //String의 상위타입으로 execution는 이를 허용하지 않는다. => 딱 현타입만 허용
        Assertions.assertThat(pointcut.matches(helloMethod, MemberSerivceImpl.class)).isFalse();
    }
}
