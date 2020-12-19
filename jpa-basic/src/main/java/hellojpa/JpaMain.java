package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Human;
import hellojpa.domain.Member;
import hellojpa.domain.Movie;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {
            Human human1 = new Human();
            human1.setName("Yoon");
            em.persist(human1);

            em.flush();
            em.clear();

            Human refMember = em.getReference(Human.class, human1.getId());
            System.out.println("refMember.getClass() = " + refMember.getClass());  //Proxy
            Hibernate.initialize(refMember); //강제초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));



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

