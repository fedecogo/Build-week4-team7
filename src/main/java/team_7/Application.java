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

















        em.close();
        emf.close();
    }
}
