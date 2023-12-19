package team_7.dao;

import team_7.entities.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(tratta);
        transaction.commit();
        System.out.println("La tratta da "+tratta.getPartenza()+ " a " + tratta.getArrivo()+ " è stata correttamente aggiunta.");
    }

    public Tratta findById (Long id){
        Tratta found = null;
        try{
            found = em.find(Tratta.class, id);
            if(found == null){
                throw new IllegalArgumentException("La tratta con id " + id + " non è stata trovata!");
            }
        }catch ( IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return found;
    }

    public void deleteById (Long id){
        Tratta found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'oggetto con tratta da " + found.getPartenza()+ " a " + found.getArrivo() + " è stato eliminato correttamente!");
        } catch (NullPointerException | IllegalArgumentException e){
            System.err.println("La tratta con id " + id + " non è stata trovata!");
        }
    }
}
