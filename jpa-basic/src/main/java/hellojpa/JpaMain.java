package hellojpa;

import hellojpa.domain.testdomain.*;

import javax.persistence.*;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {
            Human human = new Human();
            human.setName("Yoon");
            human.setHomeAddress(new Address());
            human.setWorkPeriod(new Period());
            em.persist(human);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            System.out.println("e = " + e);
        } finally {
            em.close();
        }

        emf.close();

    }

}

