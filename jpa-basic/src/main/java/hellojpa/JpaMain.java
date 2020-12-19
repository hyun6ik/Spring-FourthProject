package hellojpa;

import hellojpa.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Human human = new Human();
            human.setName("Yoon");
            human.setTeam(team);
            em.persist(human);




            em.flush();
            em.clear();

            List<Human> humans = em.createQuery("select m from Human m", Human.class)
                    .getResultList();


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

