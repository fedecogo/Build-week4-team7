package team_7.dao;

import team_7.entities.Vidimazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class VidimazioneDAO {
    private final EntityManager em;

    public VidimazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Vidimazione vidimazione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(vidimazione);
        transaction.commit();
        System.out.println("Il biglietto n° "+vidimazione.getBiglietto()+" è stato vidimato. Codice vid.: "+vidimazione.getId());
    }

    public Vidimazione findById (long id){
        Vidimazione found = null;
        try{
            found = em.find(Vidimazione.class, id);
            if(found == null){
                throw new IllegalArgumentException("La vidimazione numero " + id + " non è stata trovata!");
            }
        }catch ( IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return found;
    }

    public void deleteById (long id){
        Vidimazione found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La vidimazione n°" + id + " è stata correttamente rimossa");
        } catch (NullPointerException | IllegalArgumentException e){
            System.err.println("La vidimazione numero " + id + " non è stata trovata!");
        }
    }
}
