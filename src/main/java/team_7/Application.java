package team_7;


import team_7.dao.*;
import team_7.entities.*;
import team_7.entities.enums.*;
import team_7.functionalities.DateParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("galileo_express");
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);
        UtenteDao utenteDao = new UtenteDao(em);
        TesseraDao tesseraDao = new TesseraDao(em);
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO(em);
        BigliettoDAO bigliettoDAO = new BigliettoDAO(em);
        ManutenzioneDAO manutenzioneDAO = new ManutenzioneDAO(em);
        MezzoDiTrasportoDAO mezzoDiTrasportoDAO = new MezzoDiTrasportoDAO(em);
        PuntoVenditaDAO puntoVenditaDAO = new PuntoVenditaDAO(em);
        TrattaDAO trattaDAO = new TrattaDAO(em);
        ViaggioDAO viaggioDAO = new ViaggioDAO(em);


        //MezzoDiTrasporto busFromDb = mezzoDiTrasportoDAO.findById(104);
        //Manutenzione m1 = new Manutenzione(LocalDate.now(), "sono io il problema" , busFromDb);
         Manutenzione m1 = manutenzioneDAO.findById(108);
         m1.setDataFine(LocalDate.now());
     //   m1.setDataFine(LocalDate.now());
        manutenzioneDAO.save(m1);











        /*System.out.println("Ciao inserisci id utente");
        long idUt = Long.parseLong(sc.nextLine());
        Utente userFromDB = utenteDao.findById(idUt);

        if(userFromDB != null) System.out.println("Benvenuto!"+userFromDB);*/


        em.close();
        emf.close();
    }
}
