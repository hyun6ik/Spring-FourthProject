package hellojpa;

import hellojpa.domain.Address;
import hellojpa.domain.testdomain.*;

import javax.persistence.*;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {







//            Human human = new Human();
//            human.setName("Yoon");
//            human.setHomeAddress(new Address("city1","street","07949"));
//
//            human.getFavoriteFoods().add("치킨");
//            human.getFavoriteFoods().add("족발");
//            human.getFavoriteFoods().add("피자");
//
//            human.getAddressHistory().add(new AddressEntity("old1","street","07949"));
//            human.getAddressHistory().add(new AddressEntity("old2","street","07949"));
//
//            em.persist(human);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("==================START==============");
//            Human findHuman = em.find(Human.class, human.getId());
//            Address newAddress = new Address("NewCity", findHuman.getHomeAddress().getStreet(), findHuman.getHomeAddress().getZipcode());
//            findHuman.setHomeAddress(newAddress);
//            //치킨 -> 한식
//            findHuman.getFavoriteFoods().remove("치킨");
//            findHuman.getFavoriteFoods().add("한식");
//
//            findHuman.getAddressHistory().remove(new AddressEntity("old1","street","07949"));
//            findHuman.getAddressHistory().add(new AddressEntity("new1","street","07949"));
//
//
//            System.out.println("findHuman.getHomeAddress() = " + findHuman.getHomeAddress().getCity());
//            System.out.println("findHuman.getHomeAddress() = " + findHuman.getHomeAddress().getStreet());
//            System.out.println("findHuman.getHomeAddress() = " + findHuman.getHomeAddress().getZipcode());
//
//


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

