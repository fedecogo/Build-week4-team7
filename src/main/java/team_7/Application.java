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

        /*PuntoVendita tabacchi = puntoVenditaDAO.findById(17);
        PuntoVendita edicola = puntoVenditaDAO.findById(18);
        PuntoVendita infoP = puntoVenditaDAO.findById(19);
        PuntoVendita dist = puntoVenditaDAO.findById(20);
        Tessera t1 = tesseraDao.findById(9);
        Tessera t2 = tesseraDao.findById(10);
        Tessera t3 = tesseraDao.findById(11);
        Tessera t4 = tesseraDao.findById(12);
        Tessera t5 = tesseraDao.findById(13);
        Tessera t6 = tesseraDao.findById(14);
        Tessera t7 = tesseraDao.findById(15);
        Tessera t8 = tesseraDao.findById(16);
        Tratta palMil = trattaDAO.findById(37);
        Tratta tr1 = trattaDAO.findById(21);
        Tratta tr2 = trattaDAO.findById(26);
        Tratta tr3 = trattaDAO.findById(32);
        Abbonamento aldoPalMil = new Abbonamento(LocalDate.now(),tabacchi,t1,palMil,TipoAbbonamento.SEMESTRALE,true);
        Abbonamento abb1 = new Abbonamento(LocalDate.now(),edicola,t2,tr1,TipoAbbonamento.SETTIMANALE,false);
        Abbonamento abb2 = new Abbonamento(LocalDate.now(),infoP,t3,tr2,TipoAbbonamento.MENSILE,true);
        Abbonamento abb3 = new Abbonamento(LocalDate.now(),dist,t4,tr3,TipoAbbonamento.MENSILE,false);

        abbonamentoDAO.save(aldoPalMil);
        abbonamentoDAO.save(abb1);
        abbonamentoDAO.save(abb2);
        abbonamentoDAO.save(abb3);


         */
       MezzoDiTrasporto autobus = mezzoDiTrasportoDAO.findById(65);
       Tratta miTo = trattaDAO.findById(30);
       Viaggio viaggio1 = new Viaggio( LocalDate.now().atTime(7,30), LocalDate.now().atTime(9,39),autobus, miTo);
       viaggioDAO.save(viaggio1);


        MezzoDiTrasporto autobus1 = mezzoDiTrasportoDAO.findById(65);
        Tratta toMi = trattaDAO.findById(29);
        Viaggio viaggio2 = new Viaggio( LocalDate.now().atTime(10,30), LocalDate.now().atTime(12,32),autobus1, toMi);
        viaggioDAO.save(viaggio2);


        MezzoDiTrasporto autobus2 = mezzoDiTrasportoDAO.findById(66);
        Tratta miPa = trattaDAO.findById(46);
        Viaggio viaggio3 = new Viaggio( LocalDate.now().atTime(7,30), LocalDate.now().atTime(9,39),autobus2, miPa);
        viaggioDAO.save(viaggio3);

        MezzoDiTrasporto treno0 = mezzoDiTrasportoDAO.findById(70);
        Tratta fiBo = trattaDAO.findById(36);
        Viaggio viaggio4 = new Viaggio( LocalDate.now().atTime(7,30), LocalDate.now().atTime(9,39),treno0, fiBo );
        viaggioDAO.save(viaggio4);

        MezzoDiTrasporto treno1 = mezzoDiTrasportoDAO.findById(71);
        Tratta roFi = trattaDAO.findById(37);
        Viaggio viaggio5 = new Viaggio( LocalDate.now().atTime(7,30), LocalDate.now().atTime(9,39),treno1, roFi);
        viaggioDAO.save(viaggio5);

        MezzoDiTrasporto treno2 = mezzoDiTrasportoDAO.findById(72);
        Tratta leVe = trattaDAO.findById(50);
        Viaggio viaggio6 = new Viaggio( LocalDate.now().atTime(7,30), LocalDate.now().atTime(9,39),treno2, leVe);
        viaggioDAO.save(viaggio6);








// SOLO PER MEEEEEEEEEE FEDEEE            !!CANCELLARE I VIAGGI GIA ESISTENTI E RIEARI TUTTI QUANTI sisteemare le date in application e frae la stessa cosa di tratte per viaggi, duration in int e una roba che si chiama con la c che ora non mi ricordo







        em.close();
        emf.close();
    }
}
