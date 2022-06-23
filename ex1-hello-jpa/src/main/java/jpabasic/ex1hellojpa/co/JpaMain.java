package jpabasic.ex1hellojpa.co;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Controller
public class JpaMain {

    @GetMapping("/")
    public String JapTest(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        System.out.println("ddddddddddddd");
        System.out.println("ddddddddddddd");
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(5L);
        member.setName("HelloA");

        em.persist(member);

        tx.commit();


        em.close();

        emf.close();
        return "index";
    }

}
