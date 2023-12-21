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

        PuntoVendita tabacchino = puntoVenditaDAO.findById(17);
        Biglietto aldoBg = new Biglietto(LocalDate.now(),tabacchino,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg);
        Biglietto aldoBg1 = new Biglietto(LocalDate.now(),tabacchino,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg1);
        Biglietto aldoBg2 = new Biglietto(LocalDate.now(),tabacchino,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg2);
        Biglietto aldoBg3 = new Biglietto(LocalDate.now(),tabacchino,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg3);
        Biglietto aldoBg4 = new Biglietto(LocalDate.now(),tabacchino,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg4);

        PuntoVendita edicola = puntoVenditaDAO.findById(18);
        Biglietto aldoBg5 = new Biglietto(LocalDate.now(),edicola,TipoTratta.MEDIA);
        bigliettoDAO.save(aldoBg5);
        Biglietto aldoBg6 = new Biglietto(LocalDate.now(),edicola,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg6);
        Biglietto aldoBg7 = new Biglietto(LocalDate.now(),edicola,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg7);
        Biglietto aldoBg8 = new Biglietto(LocalDate.now(),edicola,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg8);
        Biglietto aldoBg9 = new Biglietto(LocalDate.now(),edicola,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg9);

        PuntoVendita biglietteria = puntoVenditaDAO.findById(19);
        Biglietto aldoBg51 = new Biglietto(LocalDate.now(),biglietteria,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg51);
        Biglietto aldoBg62 = new Biglietto(LocalDate.now(),biglietteria,TipoTratta.MEDIA);
        bigliettoDAO.save(aldoBg62);
        Biglietto aldoBg73 = new Biglietto(LocalDate.now(),biglietteria,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg73);
        Biglietto aldoBg84 = new Biglietto(LocalDate.now(),biglietteria,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg84);
        Biglietto aldoBg95 = new Biglietto(LocalDate.now(),biglietteria,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg95);

        PuntoVendita distributore = puntoVenditaDAO.findById(20);
        Biglietto aldoBg512 = new Biglietto(LocalDate.now(),distributore,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg512);
        Biglietto aldoBg623 = new Biglietto(LocalDate.now(),distributore,TipoTratta.MEDIA);
        bigliettoDAO.save(aldoBg623);
        Biglietto aldoBg734 = new Biglietto(LocalDate.now(),distributore,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg734);
        Biglietto aldoBg845 = new Biglietto(LocalDate.now(),distributore,TipoTratta.LUNGA);
        bigliettoDAO.save(aldoBg845);
        Biglietto aldoBg956 = new Biglietto(LocalDate.now(),distributore,TipoTratta.BREVE);
        bigliettoDAO.save(aldoBg956);

        em.close();
        emf.close();
    }
}
