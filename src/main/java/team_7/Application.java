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

        LocalDate dataEmissione = LocalDate.now();
        Utente aldo = utenteDao.findById(1);
        Tessera tesseraAldo = new Tessera(dataEmissione, aldo);
        tesseraDao.save(tesseraAldo);

        Utente giovanni = utenteDao.findById(2);
        Tessera tesseraGiovanni = new Tessera(dataEmissione, giovanni);
        tesseraDao.save(tesseraGiovanni);

        Utente giacomo = utenteDao.findById(3);
        Tessera tesserag = new Tessera(dataEmissione, giacomo);
        tesseraDao.save(tesserag);

        Utente m = utenteDao.findById(4);
        Tessera tesseram = new Tessera(dataEmissione, m);
        tesseraDao.save(tesseram);

        Utente mar = utenteDao.findById(5);
        Tessera tesseraMar = new Tessera(dataEmissione, mar);
        tesseraDao.save(tesseraMar);

        Utente lu = utenteDao.findById(6);
        Tessera tesseralu = new Tessera(dataEmissione, lu);
        tesseraDao.save(tesseralu);

        Utente p = utenteDao.findById(7);
        Tessera tesserap = new Tessera(dataEmissione, p);
        tesseraDao.save(tesserap);


        Utente b = utenteDao.findById(8);
        Tessera tessera = new Tessera(dataEmissione, b);
        tesseraDao.save(tessera);





        /*System.out.println("Ciao inserisci id utente");
        long idUt = Long.parseLong(sc.nextLine());
        Utente userFromDB = utenteDao.findById(idUt);

        if(userFromDB != null) System.out.println("Benvenuto!"+userFromDB);*/


        em.close();
        emf.close();
    }
}
