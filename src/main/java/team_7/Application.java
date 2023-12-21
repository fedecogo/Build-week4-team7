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

//tratte brevi

       /* Duration d1 = Duration.ofMinutes(120);
        Tratta t1 = new Tratta(Capolinea.MILANO, Capolinea.TORINO, d1);
        Tratta t1r = new Tratta(Capolinea.TORINO, Capolinea.MILANO, d1);
        trattaDAO.save(t1);
        trattaDAO.save(t1r);

        Duration d2 = Duration.ofMinutes(150);
        Tratta t2 = new Tratta(Capolinea.MILANO, Capolinea.BOLOGNA, d2);
        Tratta t2r = new Tratta(Capolinea.BOLOGNA, Capolinea.MILANO, d2);
        trattaDAO.save(t2);
        trattaDAO.save(t2r);

        Duration d3 = Duration.ofMinutes(100);
        Tratta t3 = new Tratta(Capolinea.NAPOLI, Capolinea.ROMA, d3);
        Tratta t3r = new Tratta(Capolinea.ROMA, Capolinea.NAPOLI, d3);
        trattaDAO.save(t3);
        trattaDAO.save(t3r);

        Duration d4 = Duration.ofMinutes(90);
        Tratta t4 = new Tratta(Capolinea.FIRENZE, Capolinea.BOLOGNA, d4);
        Tratta t4r = new Tratta(Capolinea.BOLOGNA, Capolinea.FIRENZE, d4);
        trattaDAO.save(t4);
        trattaDAO.save(t4r);
        // tratte medie

        Duration d5 = Duration.ofMinutes(200);
        Tratta t5 = new Tratta(Capolinea.FIRENZE, Capolinea.ROMA, d5);
        Tratta t5r = new Tratta(Capolinea.ROMA, Capolinea.FIRENZE, d5);
        trattaDAO.save(t5);
        trattaDAO.save(t5r);

        Duration d6 = Duration.ofMinutes(240);
        Tratta t6 = new Tratta(Capolinea.LECCE, Capolinea.PESCARA, d6);
        Tratta t6r = new Tratta(Capolinea.PESCARA, Capolinea.LECCE, d6);
        trattaDAO.save(t6);
        trattaDAO.save(t6r);

        Duration d7 = Duration.ofMinutes(260);
        Tratta t7 = new Tratta(Capolinea.VENEZIA, Capolinea.TORINO, d7);
        Tratta t7r = new Tratta(Capolinea.TORINO, Capolinea.VENEZIA, d7);
        trattaDAO.save(t7);
        trattaDAO.save(t7r);

        Duration d8 = Duration.ofMinutes(350);
        Tratta t8 = new Tratta(Capolinea.LECCE, Capolinea.ROMA, d8);
        Tratta t8r = new Tratta(Capolinea.ROMA, Capolinea.LECCE, d8);
        trattaDAO.save(t8);
        trattaDAO.save(t8r);
        // tratte lunghe

        Duration d9 = Duration.ofMinutes(960);
        Tratta t9 = new Tratta(Capolinea.MILANO, Capolinea.PALERMO, d9);
        Tratta t9r = new Tratta(Capolinea.PALERMO, Capolinea.MILANO, d9);
        trattaDAO.save(t9);
        trattaDAO.save(t9r);

        Duration d10 = Duration.ofMinutes(540);
        Tratta t10 = new Tratta(Capolinea.TORINO, Capolinea.NAPOLI, d10);
        Tratta t10r = new Tratta(Capolinea.NAPOLI, Capolinea.TORINO, d10);
        trattaDAO.save(t10);
        trattaDAO.save(t10r);

        Duration d11 = Duration.ofMinutes(570);
        Tratta t11 = new Tratta(Capolinea.LECCE, Capolinea.VENEZIA, d11);
        Tratta t11r = new Tratta(Capolinea.VENEZIA, Capolinea.LECCE, d11);
        trattaDAO.save(t11);
        trattaDAO.save(t11r);

        Duration d12 = Duration.ofMinutes(600);
        Tratta t12 = new Tratta(Capolinea.MILANO, Capolinea.NAPOLI, d12);
        Tratta t12r = new Tratta(Capolinea.NAPOLI, Capolinea.MILANO, d12);
        trattaDAO.save(t12);
        trattaDAO.save(t12r);

        LocalDate dataOggi = LocalDate.now();
        LocalDate dataVecchia = LocalDate.of(2022,01,01);
        MezzoDiTrasporto bus1 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, dataOggi);
        MezzoDiTrasporto bus2 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, dataVecchia);
        MezzoDiTrasporto bus3 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, dataVecchia);
        MezzoDiTrasporto bus4 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, dataVecchia);
        MezzoDiTrasporto bus5 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, dataVecchia);
        MezzoDiTrasporto bus6 = new MezzoDiTrasporto(TipoMezzo.AUTOBUS, dataVecchia);

        MezzoDiTrasporto tren1 = new MezzoDiTrasporto(TipoMezzo.TRENO, dataVecchia);
        MezzoDiTrasporto tren2 = new MezzoDiTrasporto(TipoMezzo.TRENO, dataVecchia);
        MezzoDiTrasporto tren3 = new MezzoDiTrasporto(TipoMezzo.TRENO, dataVecchia);
        MezzoDiTrasporto tren4 = new MezzoDiTrasporto(TipoMezzo.TRENO, dataVecchia);
        MezzoDiTrasporto tren5 = new MezzoDiTrasporto(TipoMezzo.TRENO, dataVecchia);
        MezzoDiTrasporto tren6 = new MezzoDiTrasporto(TipoMezzo.TRENO, dataVecchia);

        mezzoDiTrasportoDAO.save(bus1);
        mezzoDiTrasportoDAO.save(bus2);
        mezzoDiTrasportoDAO.save(bus3);
        mezzoDiTrasportoDAO.save(bus4);
        mezzoDiTrasportoDAO.save(bus5);
        mezzoDiTrasportoDAO.save(bus6);

        mezzoDiTrasportoDAO.save(tren1);
        mezzoDiTrasportoDAO.save(tren2);
        mezzoDiTrasportoDAO.save(tren3);
        mezzoDiTrasportoDAO.save(tren4);
        mezzoDiTrasportoDAO.save(tren5);
        mezzoDiTrasportoDAO.save(tren6);
*/
        MezzoDiTrasporto busFromDb = mezzoDiTrasportoDAO.findById(69);
        Manutenzione m1 = new Manutenzione(LocalDate.now(), "sono io il problema" , busFromDb);
       // m1.setDataFine(LocalDate.now());
        // Manutenzione m1 = manutenzioneDAO.findById(79);
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
