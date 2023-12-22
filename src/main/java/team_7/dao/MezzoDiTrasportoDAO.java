package team_7.dao;

import team_7.entities.MezzoDiTrasporto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class MezzoDiTrasportoDAO {
    private final EntityManager em;

    public MezzoDiTrasportoDAO(EntityManager em) {
        this.em = em;
    }
    public void save(MezzoDiTrasporto mezzo){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mezzo);
        transaction.commit();
        System.out.println("Il mezzo "+mezzo.getTipoMezzo()+mezzo.getId()+" è stato correttamente aggiunto al parco mezzi.");
    }
    public MezzoDiTrasporto findById(long id){
        MezzoDiTrasporto found = null;
        try{
            found=em.find(MezzoDiTrasporto.class,id);
            if(found==null){
                throw new IllegalArgumentException("Il mezzo con id "+id+" non è presente");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return found;
    }
    public void deleteById(long id){
        MezzoDiTrasporto found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il mezzo con id "+id+"è stato correttamente rimosso dal parco mezzi");
        }catch (IllegalArgumentException | NullPointerException e){
            System.err.println("Il mezzo con id "+id+" non è presente");
        }
    }
    public void mostraTuttiIMezzi() {
        TypedQuery<MezzoDiTrasporto> query = em.createQuery("SELECT m FROM MezzoDiTrasporto m", MezzoDiTrasporto.class);
        List<MezzoDiTrasporto> mezzi = query.getResultList();

        if (mezzi.isEmpty()) {
            System.out.println("Il parco mezzi è vuoto.");
        } else {
            System.out.println("Elenco di tutti i mezzi nel parco mezzi:");
            for (MezzoDiTrasporto mezzo : mezzi) {
                System.out.println("ID: " + mezzo.getId() +
                        ", Tipo: " + mezzo.getTipoMezzo() +
                        ", Altri dettagli: " + mezzo.getTipoMezzo());
                // Aggiungi altre informazioni del mezzo se necessario
            }
        }
    }

}
