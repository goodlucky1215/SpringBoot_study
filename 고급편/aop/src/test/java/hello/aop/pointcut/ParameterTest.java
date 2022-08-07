package hello.aop.pointcut;

import hello.aop.member.MemberSerivce;
import hello.aop.member.annotation.ClassAop;
import hello.aop.member.annotation.MethodAop;
import hello.aop.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(ParameterTest.ParameterAspect.class)
@SpringBootTest
public class ParameterTest {

    @Autowired
    MemberSerivce memberSerivce;

    @Test
    void success(){
        log.info("memberSerivce Proxy = {}", memberSerivce.getClass());
        memberSerivce.hello("helloA");
    }

    @Slf4j
    @Aspect
    static class ParameterAspect{

        @Pointcut("execution(* hello.aop.member..*.*(..))")
        private void allMember(){}

        @Around("allMember()")
        public Object logArgs1(ProceedingJoinPoint joinPoint) throws Throwable {
            Object arg1 = joinPoint.getArgs()[0];
            log.info("[logArgs1] {}, arg={}", joinPoint.getSignature(),arg1);
            return joinPoint.proceed();
        }

        @Around("allMember() && args(arg,..)")
        public Object logArgs2(ProceedingJoinPoint joinPoint, Object arg) throws Throwable {
            log.info("[logArgs1] {}, arg={}", joinPoint.getSignature(),arg);
            return joinPoint.proceed();
        }

        @Before("allMember() && args(arg,..)")
        public void logArgs3(String arg) throws Throwable {
            log.info("[logArgs3] arg={}", arg);
        }

        @Before("allMember() && this(obj)")
        public void thisArgs(JoinPoint joinPoint, MemberSerivce obj) {
            log.info("[this]{}, arg={}",joinPoint.getSignature(), obj.getClass());
        }

        @Before("allMember() && target(obj)")
        public void targetArgs(JoinPoint joinPoint, MemberSerivce obj) {
            log.info("[target]{}, arg={}",joinPoint.getSignature(), obj.getClass());
        }

        @Before("allMember() && @target(annotation)")
        public void atTarget(JoinPoint joinPoint, ClassAop annotation) {
            log.info("[@target]{}, arg={}",joinPoint.getSignature(), annotation);
        }

        @Before("allMember() && @within(annotation)")
        public void atWithin(JoinPoint joinPoint, ClassAop annotation) {
            log.info("[@within]{}, arg={}",joinPoint.getSignature(), annotation);
        }

        @Before("allMember() && @annotation(annotation)")
        public void atAnnotation(JoinPoint joinPoint, MethodAop annotation) {
            log.info("[@annotation]{}, annotationValue={}",joinPoint.getSignature(), annotation.value());
        }
    }
}
