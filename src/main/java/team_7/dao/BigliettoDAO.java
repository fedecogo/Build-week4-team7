package team_7.dao;

import team_7.entities.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BigliettoDAO {
    private EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Biglietto biglietto){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(biglietto);
        transaction.commit();
        System.out.println("Biglietto n°: " + biglietto.getId()+ " salvato.");
    }

    public Biglietto findById (long id){
        return em.find(Biglietto.class,id);
    }

    public void delete (Biglietto biglietto){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(biglietto);
        transaction.commit();
        System.out.println("Biglietto n°: " + biglietto.getId()+ " rimosso.");
    }
}
