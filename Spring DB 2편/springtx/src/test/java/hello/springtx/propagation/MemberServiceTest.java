package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    LogRepository logRepository;

    /**
     * MemberService @Transactional:OFF
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON
     */
    @Test
    void outerTxOff_success(){
        //given
        String username = "outerTxOff_success";

        //when
        memberService.joinV1(username);

        //when : 모든 데이터가 정상 저장된다.
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * MemberService @Transactional:OFF
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON Exception
     */
    @Test
    void outerTxOff_fail(){
        //given
        String username = "로그예외outerTxOff_success";

        //when
        Assertions.assertThatThrownBy(()->memberService.joinV1(username))
            .isInstanceOf(RuntimeException.class);

        //when : memberRepository는 저장, logRepository는 롤백
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(!logRepository.find(username).isPresent());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:OFF
     * LogRepository @Transactional:OFF
     */
    @Test
    void singleTx(){
        //given
        String username = "singleTx";

        //when
        memberService.joinV1(username);

        //when : 모든 데이터가 정상 저장된다.
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * MemberService @Transactional:ON
     * MemberRepository @Transactional:ON
     * LogRepository @Transactional:ON
     */
    @Test
    void outerTxOn_success(){
        //given
        String username = "outerTxOn_success";

        //when
        memberService.joinV1(username);

        //when : 모든 데이터가 정상 저장된다.
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /*
     * memberService      @Transactional:ON
     * memberRepository   @Transactional:ON
     * logRepository      @Transactional:ON Exception
     */
    @Test
    void outerTxOn_fail(){
        //given
        String username = "로그예외outerTxOn_fail";

        //when
        Assertions.assertThatThrownBy(()->memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        //when : 모든 데이터가 롤백된다.
        assertTrue(!memberRepository.find(username).isPresent());
        assertTrue(!logRepository.find(username).isPresent());
    }


    /*
     * memberService      @Transactional:ON
     * memberRepository   @Transactional:ON
     * logRepository      @Transactional:ON Exception
     */
    @Test
    void recoverException_fail(){
        //given
        String username = "로그예외recoverException_fail";

        //when
        Assertions.assertThatThrownBy(()->memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        //when : 모든 데이터가 롤백된다.
        assertTrue(!memberRepository.find(username).isPresent());
        assertTrue(!logRepository.find(username).isPresent());
    }

    /*
     * memberService      @Transactional:ON
     * memberRepository   @Transactional:ON
     * logRepository      @Transactional:ON(REQUIRES_NEW) Exception
     */
    @Test
    void recoverException_suceess(){
        //given
        String username = "로그예외_recoverException_suceess";

        //when
        memberService.joinV2(username);

        //when : member 저장, log 롤백
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(!logRepository.find(username).isPresent());
    }
}