package jpabasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaMain {

    private final EntityManager em;

    @Autowired
    public JpaMain(EntityManager em) {
        this.em = em;
    }

    /*
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //em.close();

        //emf.close();
    }
     */
}
