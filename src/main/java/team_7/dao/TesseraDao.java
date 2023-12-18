package team_7.dao;

import team_7.entities.Tessera;
import team_7.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TesseraDao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("galileo_express");

    public void createTessera(Tessera tessera) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(tessera);
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

    public Tessera getTesseraById(long tesseraId) {
        EntityManager em = emf.createEntityManager();
        Tessera tessera = null;

        try {
            tessera = em.find(Tessera.class, tesseraId);
        } finally {
            em.close();
        }

        return tessera;
    }

    public List<Tessera> getTessereByUtente(Utente utente) {
        EntityManager em = emf.createEntityManager();
        List<Tessera> tessere = null;

        try {
            tessere = em.createQuery("SELECT t FROM Tessera t WHERE t.utente = :utente", Tessera.class)
                    .setParameter("utente", utente)
                    .getResultList();
        } finally {
            em.close();
        }

        return tessere;
    }
}
