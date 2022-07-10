package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @PersistenceContext
    EntityManager entityManager;



    @Test
    //@Rollback(false) // => 저장되니깐 이렇게 하지말고, flush를 써서 insert보내는 것 까지 확인해볼 수 있다.
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("Lee1");

        //when
        Long savedId = memberService.join(member);

        //then
        entityManager.flush();
        assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);

        //then
        assertThrows(IllegalStateException.class,() ->{
            memberService.join(member2);
        });

        //then => fail까지 오면 에러난다는 의미
        //fail("예외가 발생해야 한다.");
    }



}