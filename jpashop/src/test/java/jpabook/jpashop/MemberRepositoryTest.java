package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository1 memberRepository;

    @Test
    @Transactional //롤백해서 값이 저장안되게 함
    @Rollback(false) //값이 저장되도록함
    public void testMember() throws Exception{
        //given
        Member1 member = new Member1();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member1 findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); //이건 true => 영속성 컨텍스트 => insert에 있어서, select하지않고 insert 캐시에 있는 걸 꺼내서 비교함.
    }
}