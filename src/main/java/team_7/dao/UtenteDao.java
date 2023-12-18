package team_7.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import team_7.entities.Utente;

public class UtenteDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("galileo_express");

    public void createUtente(Utente utente) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(utente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public List<Utente> getAllUtenti() {
        EntityManager em = emf.createEntityManager();
        List<Utente> utenti = null;

        try {
            utenti = em.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();
        } finally {
            em.close();
        }

        return utenti;
    }
    public Utente getUtenteById(long utenteId) {
        EntityManager em = emf.createEntityManager();
        Utente utente = null;

        try {
            utente = em.find(Utente.class, utenteId);
        } finally {
            em.close();
        }

        return utente;
    }

    // delate utente
}
