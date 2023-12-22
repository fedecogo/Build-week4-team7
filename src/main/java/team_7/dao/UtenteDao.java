package team_7.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import team_7.entities.Utente;

import java.util.List;


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

    public List<Utente> mostraTuttiGliUtenti() {
        TypedQuery<Utente> query = em.createQuery("SELECT u FROM Utente u", Utente.class);
        List<Utente> utenti = query.getResultList();

        if (utenti.isEmpty()) {
            System.out.println("Non ci sono utenti registrati al momento.");
        } else {
            System.out.println("Elenco di tutti gli utenti:");
            for (Utente utente : utenti) {
                System.out.println("ID: " + utente.getId() +
                        ", Nome: " + utente.getNome() +
                        ", Cognome: " + utente.getCognome() +
                        ",");
            }
        }

        return utenti;
    }
}
