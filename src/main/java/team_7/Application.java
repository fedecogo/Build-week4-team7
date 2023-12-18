package team_7;

import team_7.dao.TesseraDao;
import team_7.dao.UtenteDao;
import team_7.entities.Tessera;
import team_7.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("galileo_express");
        EntityManager em = emf.createEntityManager();


        UtenteDao utenteDao = new UtenteDao();
        TesseraDao tesseraDao = new TesseraDao();

        Utente utente = new Utente("Mario", "Rossi", LocalDate.of(1990, 5, 15));
        utenteDao.createUtente(utente);
//        Utente utenteRecuperato = utenteDao.getUtenteById(1);
        Utente utenteRecuperato = utenteDao.getUtenteById(1);

        Tessera tessera = new Tessera( LocalDate.of(2002,03,03) , LocalDate.of(2002,03,03) , utenteRecuperato);
        tesseraDao.createTessera(tessera);

        List<Tessera> tessereUtente = tesseraDao.getTessereByUtente(utenteRecuperato);


        System.out.println("Utente: " + utenteRecuperato);
        for (Tessera t : tessereUtente) {
            System.out.println("Tessera associata: " + t);
        }

        em.close();
        emf.close();
    }
}
