package team_7.dao;

import team_7.entities.Abbonamento;
import team_7.entities.Biglietto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbbonamentoDAO {
    private EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Abbonamento abbonamento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(abbonamento);
        transaction.commit();
        String strOpz = abbonamento.isAndataERitorno() ? " (andata e ritorno)" : "";
        System.out.println("L'abbonamento"+ strOpz +" n° " + abbonamento.getId()+ " da "+abbonamento.getTratta().getPartenza()+ " a "+abbonamento.getTratta().getArrivo()+" è stato salvato.");
    }

    public Abbonamento findById (long id){
        return em.find(Abbonamento.class,id);
    }

    public void delete (Abbonamento abbonamento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(abbonamento);
        transaction.commit();
        System.out.println("Biglietto n°: " + abbonamento.getId()+ " rimosso.");
    }
}
