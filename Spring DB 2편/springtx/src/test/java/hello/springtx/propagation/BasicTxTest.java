package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class BasicTxTest {

    @Autowired
    PlatformTransactionManager txManager;

    @TestConfiguration
    static class Config{
        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource){
            return new DataSourceTransactionManager(dataSource);
        }
    }

    @Test
    void commit(){
        log.info("트랜잭션 시작");
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋 시작");
        txManager.commit(status);
        log.info("트랜잭션 커밋 완료");
    }
    
    @Test
    void rollback(){
        log.info("트랜잭션 시작");
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 롤백 시작");
        txManager.rollback(status);
        log.info("트랜잭션 롤백 완료");
    }

    @Test
    void double_commit(){
        log.info("트랜잭션1 시작");
        TransactionStatus status1 = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션1 커밋 시작");
        txManager.commit(status1);
        log.info("트랜잭션1 커밋 완료");

        log.info("트랜잭션2 시작");
        TransactionStatus status2 = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋2 시작");
        txManager.commit(status2);
        log.info("트랜잭션 커밋2 완료");
    }

    @Test
    void double_commit_rollback(){
        log.info("트랜잭션 시작");
        TransactionStatus status1 = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋 시작");
        txManager.commit(status1);
        log.info("트랜잭션 커밋 완료");

        log.info("트랜잭션 시작");
        TransactionStatus status2 = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 롤백 시작");
        txManager.rollback(status2);
        log.info("트랜잭션 롤백 완료");
    }

    @Test //커밋된다.
    void inneer_commit(){
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", inner.isNewTransaction());
        log.info("내부 트랜잭션 커밋 ");
        txManager.commit(inner);

        log.info("외부 트랜잭션 커밋 ");
        txManager.commit(outer);
    }

    @Test //롤백된다. => 하나라도 롤백되면 롤백된다.
    void outer_rollback(){
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", inner.isNewTransaction());
        log.info("내부 트랜잭션 커밋 ");
        txManager.commit(inner);

        log.info("외부 트랜잭션 롤백 ");
        txManager.rollback(outer);
    }

    @Test //롤백됨 => 하나라도 롤백되면 롤백된다.
    void inner_rollback(){
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", inner.isNewTransaction());
        log.info("내부 트랜잭션 롤백 ");
        txManager.rollback(inner);

        log.info("외부 트랜잭션 커밋 ");
        txManager.commit(outer);
    }

    @Test //각각 외부, 내부 다른 커낵션을 사용
    void inner_rollback_enw(){
        log.info("외부 트랜잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

        log.info("내부 트랜잭션 시작");
        DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute();
        defaultTransactionAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus inner = txManager.getTransaction(defaultTransactionAttribute);
        log.info("outer.isNewTransaction()={}", inner.isNewTransaction());
        log.info("내부 트랜잭션 롤백 ");
        txManager.rollback(inner);

        log.info("외부 트랜잭션 커밋 ");
        txManager.commit(outer);
    }


}
