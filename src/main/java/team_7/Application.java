package team_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team_7.dao.AbbonamentoDAO;
import team_7.dao.BigliettoDAO;
import team_7.entities.Abbonamento;
import team_7.entities.Biglietto;
import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoTratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("galileo_express");
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();


        BigliettoDAO bd = new BigliettoDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);

        Biglietto bus = new Biglietto(LocalDate.of(2023,5,8),43435, TipoTratta.MEDIA);
        bd.save(bus);

        Abbonamento treno = new Abbonamento(LocalDate.of(2023,3,28),544,TipoTratta.LUNGA,LocalDate.of(2024,3,27), StatoAbbonamento.ATTIVO,343,"annuale");
        ad.save(treno);


        em.close();
        emf.close();
    }
}
