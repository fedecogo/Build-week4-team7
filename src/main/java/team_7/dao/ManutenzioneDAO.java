package team_7.dao;

import team_7.entities.Manutenzione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ManutenzioneDAO {
    private final EntityManager em;

    public ManutenzioneDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Manutenzione manutenzione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manutenzione);
        transaction.commit();
        System.out.println("La manutenzione del "+manutenzione.getMezzo().getTipoMezzo()+ " con id "  +manutenzione.getId()+" del "+manutenzione.getDataInizio()+" è stata correttamente registrata.");
    }
    public Manutenzione findById(long id){
        Manutenzione found = null;
        try{
            found=em.find(Manutenzione.class,id);
            if(found==null){
                throw new IllegalArgumentException("La manutenzione con id "+id+" non è presente nel database");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return found;
    }

}
