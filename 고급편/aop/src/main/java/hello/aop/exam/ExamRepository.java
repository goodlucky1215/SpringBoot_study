package hello.aop.exam;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


@Repository
@Slf4j
public class ExamRepository {

    private static int seq = 0;

    /*
    *  5번에 1번 실패하는 요청청
    */
    @Trace
    @Retry(value = 4)
    public String save(String itemId){
        seq++;
        log.info("seq = {}",seq);
        if(seq%5==0){
            throw new IllegalStateException("예외 발새애애생");
        }
        return "ok";
    }
}
