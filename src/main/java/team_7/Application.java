package team_7;


import team_7.dao.*;
import team_7.entities.*;
import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoRivenditore;
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

        PuntoVendita tabacchino = new RivenditoreAutorizzato("Rossi Tabacchi srl","Roma", TipoRivenditore.TABACCHINO);
        PuntoVendita edicola = new RivenditoreAutorizzato("La Pineta","Pescara", TipoRivenditore.EDICOLA);
        PuntoVendita biglietteria = new RivenditoreAutorizzato("Galileo Info Point","Bagnone", TipoRivenditore.BIGLIETTERIA);
        PuntoVendita distributore = new DistributoreAutomatico("Sono un povero distributore","Cloud");

        puntoVenditaDAO.save(tabacchino);
        puntoVenditaDAO.save(edicola);
        puntoVenditaDAO.save(biglietteria);
        puntoVenditaDAO.save(distributore);





        /*System.out.println("Ciao inserisci id utente");
        long idUt = Long.parseLong(sc.nextLine());
        Utente userFromDB = utenteDao.findById(idUt);

        if(userFromDB != null) System.out.println("Benvenuto!"+userFromDB);*/


        em.close();
        emf.close();
    }
}
