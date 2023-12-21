package team_7.dao;

import team_7.entities.Tessera;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDao {
    private final EntityManager em;

    public TesseraDao(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(tessera);
        transaction.commit();
        System.out.println("La tessera n° " + tessera.getId_tessera() + " è stata correttamente registrata!");
    }

    public Tessera findById (long id){
        Tessera found = null;
        try{
            found = em.find(Tessera.class, id);
            if(found == null){
                throw new IllegalArgumentException("La tessera con id " + id + " non è stata trovata!");
            }
        }catch ( IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return found;
    }

    public void deleteById (long id){
        Tessera found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("La tessera n°" + id + " è stata correttamente rimossa!");
        } catch (NullPointerException | IllegalArgumentException e){
            System.err.println("La tessera con id" + id + " non è stata trovata!");
        }
    }
}
