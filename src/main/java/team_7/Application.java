package team_7;


import team_7.dao.*;
import team_7.entities.Tessera;
import team_7.entities.Utente;
import team_7.entities.Abbonamento;
import team_7.entities.Biglietto;
import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoTratta;
import team_7.functionalities.DateParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        LocalDate aldosBirthday = DateParser.parseDateForItaly("28/09/1958");
        LocalDate giovannisBirthday = DateParser.parseDateForItaly("20/02/1957");
        LocalDate giacomosBirthday = DateParser.parseDateForItaly("26/04/1956");
        LocalDate marinasBirthday = DateParser.parseDateForItaly("16/05/1963");

        Utente aldo = new Utente("Aldo","Baglio",aldosBirthday);
        Utente giovanni = new Utente("Giovanni","Storti",giovannisBirthday);
        Utente giacomo = new Utente("Giacomo","Poretti",giacomosBirthday);
        Utente marina = new Utente("Marina","Massironi",marinasBirthday);

        utenteDao.save(aldo);
        utenteDao.save(giovanni);
        utenteDao.save(giacomo);
        utenteDao.save(marina);

        LocalDate marioBd = DateParser.parseDateForItaly("05/04/1980");
        LocalDate luigiBd = DateParser.parseDateForItaly("22/02/1989");
        LocalDate peachBd = DateParser.parseDateForItaly("07/11/1993");
        LocalDate bowserBd = DateParser.parseDateForItaly("18/10/1975");

        Utente mario = new Utente("Mario","Bros",marioBd);
        Utente luigi = new Utente("Luigi","Bros",luigiBd);
        Utente peach = new Utente("Peach","Toadstool",peachBd);
        Utente bowser = new Utente("Bowser","Coopa",bowserBd);

        utenteDao.save(mario);
        utenteDao.save(luigi);
        utenteDao.save(peach);
        utenteDao.save(bowser);


        /*System.out.println("Ciao inserisci id utente");
        long idUt = Long.parseLong(sc.nextLine());
        Utente userFromDB = utenteDao.findById(idUt);

        if(userFromDB != null) System.out.println("Benvenuto!"+userFromDB);*/


        em.close();
        emf.close();
    }
}
