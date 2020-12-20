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
            Address address = new Address("city", "street", "10000");

            Human human1 = new Human();
            human1.setName("Yoon");
            human1.setHomeAddress(address);
            em.persist(human1);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            human1.setHomeAddress(newAddress);



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

