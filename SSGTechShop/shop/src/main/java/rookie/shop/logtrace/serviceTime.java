package rookie.shop.logtrace;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class serviceTime {

    //@Pointcut("@annotation(rookie.shop.logtrace.Timer)")
    //private void timer() {}

    @Pointcut("execution(* rookie.shop.controller..*Controller.*(..))")
    private void timer() {}

    @Around("timer()")
    public Object doTrace(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.info("[method] {}, [timer] {}",signature.getMethod().getName(),totalTimeMillis);
        return result;
    }

}
