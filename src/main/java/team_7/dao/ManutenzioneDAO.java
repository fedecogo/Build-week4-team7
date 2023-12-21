package team_7.dao;

import team_7.entities.Manutenzione;
import team_7.entities.enums.TipoMezzo;

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
        String stringaOpz = manutenzione.getMezzo().getTipoMezzo() == TipoMezzo.AUTOBUS ? "l' " : " ";
        System.out.println("La manutenzione n° "+manutenzione.getId() +" del" + stringaOpz + manutenzione.getMezzo().getTipoMezzo()+ " con id "  +manutenzione.getMezzo().getId() +" in data "+ manutenzione.getDataInizio()+" è stata correttamente registrata.");
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
