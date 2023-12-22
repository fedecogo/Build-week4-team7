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

        MezzoDiTrasporto autobus = mezzoDiTrasportoDAO.findById(46);
        Tratta miTo = trattaDAO.findById(59);
        Viaggio viaggio1 = new Viaggio( LocalDate.now().atTime(7,30), LocalDate.now().atTime(9,39),autobus, miTo);
        viaggioDAO.save(viaggio1);

        MezzoDiTrasporto autobus1 = mezzoDiTrasportoDAO.findById(46);
        Tratta toMi = trattaDAO.findById(58);
        Viaggio viaggio2 = new Viaggio( LocalDate.now().atTime(10,30), LocalDate.now().atTime(12,32),autobus1, toMi);
        viaggioDAO.save(viaggio2);

        MezzoDiTrasporto autobus2 = mezzoDiTrasportoDAO.findById(49);
        Tratta miPa = trattaDAO.findById(75);
        Viaggio viaggio3 = new Viaggio( LocalDate.now().atTime(5,30), LocalDate.now().atTime(19,39),autobus2, miPa);
        viaggioDAO.save(viaggio3);

        MezzoDiTrasporto treno0 = mezzoDiTrasportoDAO.findById(52);
        Tratta fiBo = trattaDAO.findById(65);
        Viaggio viaggio4 = new Viaggio( LocalDate.now().atTime(10,30), LocalDate.now().atTime(11,9),treno0, fiBo );
        viaggioDAO.save(viaggio4);

        MezzoDiTrasporto treno1 = mezzoDiTrasportoDAO.findById(53);
        Tratta roFi = trattaDAO.findById(66);
        Viaggio viaggio5 = new Viaggio( LocalDate.now().atTime(11,30), LocalDate.now().atTime(13,34),treno1, roFi);
        viaggioDAO.save(viaggio5);

        MezzoDiTrasporto treno2 = mezzoDiTrasportoDAO.findById(54);
        Tratta leVe = trattaDAO.findById(79);
        Viaggio viaggio6 = new Viaggio( LocalDate.now().atTime(3,30), LocalDate.now().atTime(22,39),treno2, leVe);
        viaggioDAO.save(viaggio6);

        em.close();
        emf.close();
    }
}
