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








        /*
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



        PuntoVendita tabacchi = puntoVenditaDAO.findById(17);


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
        Viaggio viaggio3 = new Viaggio( LocalDate.now().atTime(5,30), LocalDate.now().atTime(19,39),autobus2, miPa);
        viaggioDAO.save(viaggio3);

        MezzoDiTrasporto treno0 = mezzoDiTrasportoDAO.findById(70);
        Tratta fiBo = trattaDAO.findById(36);
        Viaggio viaggio4 = new Viaggio( LocalDate.now().atTime(10,30), LocalDate.now().atTime(11,9),treno0, fiBo );
        viaggioDAO.save(viaggio4);

        MezzoDiTrasporto treno1 = mezzoDiTrasportoDAO.findById(71);
        Tratta roFi = trattaDAO.findById(37);
        Viaggio viaggio5 = new Viaggio( LocalDate.now().atTime(11,30), LocalDate.now().atTime(13,34),treno1, roFi);
        viaggioDAO.save(viaggio5);

        MezzoDiTrasporto treno2 = mezzoDiTrasportoDAO.findById(72);
        Tratta leVe = trattaDAO.findById(50);
        Viaggio viaggio6 = new Viaggio( LocalDate.now().atTime(3,30), LocalDate.now().atTime(22,39),treno2, leVe);
        viaggioDAO.save(viaggio6);


*/

        while (true) {
            System.out.println("Cosa vuoi fare?");
            System.out.println("1. Creare un abbonamento");
            System.out.println("2. Comprare un biglietto");
            System.out.println("3. Uscire");

            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Per poter creare un abbonamento è necessario registrarti");
                    System.out.println("Dicci un po' di te, come ti chiami?");
                    String nome = sc.nextLine();
                    System.out.println("Inserisci il tuo cognome:");
                    String cognome = sc.nextLine();
                    System.out.println("In che giorno sei nato? (esempio 30/12/1900)");
                    String dataNascita = sc.nextLine();
                    LocalDate nuovoUtenteData = DateParser.parseDateForItaly(dataNascita);
                    System.out.println(nuovoUtenteData);
                    Utente nuovoUtente = new Utente(nome, cognome, nuovoUtenteData);
                    utenteDao.save(nuovoUtente);

                    LocalDate dataEmissione = LocalDate.now();
                    Tessera tesseraNuova = new Tessera(dataEmissione, nuovoUtente);
                    tesseraDao.save(tesseraNuova);

                    System.out.println("Benvenuto "+ nome + " sei stato assegnato alla tessera con id "+ tesseraNuova.getId_tessera());
                    System.out.println("Vuoi acquistare un abbonamento per un viaggio? si o no ");
                    String scelta2 = sc.nextLine();
                    if (scelta2 != "no"){
                        System.out.println("Otiima ide eccco le tratte disponibili:");
                    }
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("Grazie per aver utilizzato Galileo Express aloaaaaaa!");
                    em.close();
                    emf.close();
                    System.exit(0);

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

    }
}
