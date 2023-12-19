package team_7.dao;

import team_7.entities.PuntoVendita;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PuntoVenditaDAO {
    private final EntityManager em;

    public PuntoVenditaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PuntoVendita puntoVendita){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(puntoVendita);
        transaction.commit();
        System.out.println("Il punto vendita "+ puntoVendita.getNome()+"è stato aggiunto correttamente");
    }
    public PuntoVendita findById(long id){
        PuntoVendita found = null;
        try{
            found=em.find(PuntoVendita.class,id);
            if(found == null){
                throw new IllegalArgumentException("Il punto vendita con id "+id+"non è presente nel database");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        return found;
    }
    public void deleteById(long id){
        PuntoVendita found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        try{
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Il punto vendita "+found.getNome()+" è stato correttamente rimosso");
        } catch(IllegalArgumentException | NullPointerException e){
            System.err.println("Il punto vendita con id "+id+"non è presente nel database");
        }
    }
}