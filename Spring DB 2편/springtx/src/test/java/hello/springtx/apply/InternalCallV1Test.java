package hello.springtx.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
public class InternalCallV1Test {

    @Autowired
    CallService callService;

    @Test
    void printProxy() {
        log.info("callService class={}", callService.getClass());
    }
    @Test
    void internalCall() {
        callService.internal();
    }

    //트랜잭션이 적용 안된 메소드 안에 트랜잭션이 적용된 메소드를 넣으면, 그 트랜잭션이 적용된 메소드로 실행되지 않는다.(같은 한 클래스안에 메소드들)
    //=>트랜잭션이 적용된 메소드로 사용하려면? 따로 클래스를 빼서 트랜잭션 메소드를 넣고 호출해주면 된다.(서로 다른 클래스에 메소드)
    @Test
    void externalCall() {
        callService.external();

    }

    @TestConfiguration
    static class InternalCallV1Config{
        @Bean
        CallService callService(){
            return new CallService();
        }
    }

    @Slf4j
    static class CallService{

        public void external(){
            log.info("call external");
            printTxInfo();
            internal();
        }

        @Transactional
        public void internal() {
            log.info("call internal");
            printTxInfo();
        }

        private void printTxInfo() {
            boolean txActive =
                    TransactionSynchronizationManager.isActualTransactionActive();
            log.info("tx active={}", txActive);
        }
    }

}
