package hello.springtx.propagation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    @Transactional
    public void save(Member member){
        log.info("member 저장");
        em.persist(member);
    }

    public Optional<Member> find(String username){
        return em.createQuery("select m from Member m where m.username =:username")
                .setParameter("username",username)
                .getResultList().stream().findAny();
        //1개찾는 getSingleResult()메소드도 있긴한데, 값이 없으면 Exception이 터짐
        //그래서 .getResultList().stream().findAny();를 사용함 => 값이 여러개면 아무거나 반납(어차피 1개 값이면 걔를 반납할테니)/없어도 에러x
    }
}
