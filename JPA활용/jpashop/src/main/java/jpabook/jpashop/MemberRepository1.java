package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository1 {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member1 member){
        em.persist(member);
        return member.getId();
    }

    public Member1 find(Long id){
        return em.find(Member1.class, id);
    }

}
