package hellojpa;

import hellojpa.domain.Member;
import hellojpa.testdomain.Human;
import hellojpa.testdomain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);


            Human human = new Human();
            human.setName("Yoon");

            team.addMember(human);
            em.persist(human);






            em.flush();
            em.clear();


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
