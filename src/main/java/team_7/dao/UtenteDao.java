package team_7.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import team_7.entities.Utente;


public class UtenteDao {
    private final EntityManager em;

    public UtenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L' utente "+utente.getCognome()+" "+ utente.getNome() + " è stato salvato");
    }

    public Utente findById (long id){
        Utente found = null;
        try{
            found = em.find(Utente.class, id);
            if(found == null){
                throw new IllegalArgumentException("L' utente con id: " + id + " non è stato trovato!");
            }
        }catch ( IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return found;
    }

    public void deleteById (long id){
        Utente found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L' utente con id: " + id + " è stato correttamente rimosso!");
        } catch (NullPointerException | IllegalArgumentException e){
            System.err.println("L' utente con id: " + id +  " non è stato trovato!");
        }
    }
}
