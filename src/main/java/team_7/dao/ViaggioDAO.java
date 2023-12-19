package team_7.dao;

import team_7.entities.Tratta;
import team_7.entities.Viaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ViaggioDAO {
    private final EntityManager em;

    public ViaggioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Viaggio viaggio){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(viaggio);
        transaction.commit();
        System.out.println("Il viaggio n° " + viaggio.getId() + " è stato correttamente registrato");
    }

    public Viaggio findById (long id){
        Viaggio found = null;
        try{
            found = em.find(Viaggio.class, id);
            if(found == null){
                throw new IllegalArgumentException("Il viaggio con id " + id + " non è stato trovato!");
            }
        }catch ( IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return found;
    }

    public void deleteById (long id){
        Viaggio found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il viaggio n°" + id + " è stato correttamente rimosso");
        } catch (NullPointerException | IllegalArgumentException e){
            System.err.println("Il viaggio con id" + id + " non è stato trovato!");
        }
    }
}
