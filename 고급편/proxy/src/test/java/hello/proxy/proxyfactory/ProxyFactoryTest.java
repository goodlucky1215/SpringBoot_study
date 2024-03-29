package hello.proxy.proxyfactory;

import hello.proxy.common.advice.TimeAdvice;
import hello.proxy.common.service.ConcreteService;
import hello.proxy.common.service.ServiceImpl;
import hello.proxy.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK동적 프록시 사용")
    void interfaceProxy(){
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.save();
        proxy.find();
        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue(); //인터페이스 클래스일 경우
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse(); //구현체 클래스일 경우
    }

    @Test
    @DisplayName("구체 클래스만 있으면 CGLIB 사용")
    void concreteProxy(){
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.call();
        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse(); //인터페이스 클래스일 경우
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue(); //구현체 클래스일 경우
    }

    @Test
    @DisplayName("proxyTargetClass옵션을 사용하면 인터페이스가 있어도 CGLIB사용, 클래스 기반 프록시 사요")
    void proxyTargetClass(){
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); //proxyTargetClass옵션을 사용하면 인터페이스가 있어도 CGLIB사용
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.save();
        proxy.find();
        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse(); //인터페이스 클래스일 경우
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue(); //구현체 클래스일 경우
    }

}
