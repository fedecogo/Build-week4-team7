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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Admin {
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
        VidimazioneDAO vidimazioneDAO = new VidimazioneDAO(em);



        do {
            System.out.println("Inserisci la password");
            int password = sc.nextInt();

            if (password == 1234) {
                System.out.println("Benvenuto Administrator, inserisci la tua scelta");
                System.out.println("Ecco le opzioni disponibili ");
                System.out.println("1 Crea un nuovo viaggio");
                System.out.println("2 Aggiungi un nuovo mezzo al parco mezzi");
                System.out.println("3 Visualizza tutti gli utenti");
                System.out.println("4 Metti un mezzo in manutenzione");


               int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Per quale tratta vuoi creare il nuovo viaggio?");
                        trattaDAO.mostraTutteLeTratte();
                        System.out.println("Scegli l'id della tua tratta:");
                        long idTrattaAdmin = sc.nextLong();
                        sc.nextLine();
                        Tratta trattaScelta = trattaDAO.findById(idTrattaAdmin);

                        System.out.println("Perfetto, ora scegli l'id del mezzo che vuoi utilizzare per il tuo nuovo viaggio:");
                        mezzoDiTrasportoDAO.mostraTuttiIMezzi();
                        long idMezzoScelto = sc.nextLong();
                        MezzoDiTrasporto mezzoScelto = mezzoDiTrasportoDAO.findById(idMezzoScelto);


                        System.out.println("Ora dobbiamo scegliere giorno e l'orario di partenza");
                        System.out.println("Inserisci il giorno (esempio 03):");
                        int giornoPartenza = sc.nextInt();
                        System.out.println("Inserisci il mese (esempio 03):");
                        int mesePartenza = sc.nextInt();
                        System.out.println("Inserisci l'anno:");
                        int annoPartenza = sc.nextInt();
                        System.out.println("Inserisci l'ora di partenza (esempio 07):");
                        int oraPartenza = sc.nextInt();
                        System.out.println("Inserisci i minuti di partenza (esempio 02):");
                        int minPartenza = sc.nextInt();
                        LocalDateTime orarioPartenza = LocalDateTime.of(annoPartenza, mesePartenza, giornoPartenza, oraPartenza, minPartenza);

                        System.out.println("Perfetto, la tua tratta ci mette circa " + trattaScelta.getDurataMedia() + " min");
                        System.out.println("Ora dobbiamo scegliere giorno e l'orario di arrivo");

                        System.out.println("Inserisci il giorno (esempio 03):");
                        int giornoArrivo = sc.nextInt();
                        System.out.println("Inserisci il mese (esempio 03):");
                        int meseArrivo = sc.nextInt();
                        System.out.println("Inserisci l'anno:");
                        int annoArrivo = sc.nextInt();
                        System.out.println("Inserisci l'ora di arrivo (esempio 09):");
                        int oraArrivo = sc.nextInt();
                        System.out.println("Inserisci i minuti di arrivo (esempio 30):");
                        int minArrivo = sc.nextInt();
                        LocalDateTime orarioArrivo = LocalDateTime.of(annoArrivo, meseArrivo, giornoArrivo, oraArrivo, minArrivo);

                        Viaggio nuovoViaggio = new Viaggio(orarioPartenza, orarioArrivo, mezzoScelto, trattaScelta);
                        viaggioDAO.save(nuovoViaggio);
                        System.out.println(nuovoViaggio + " salvato");

                        break;

                    case 2:
                        System.out.println("Hai scelto di inserire un nuovo mezzo:");
                        System.out.println("1 Treno");
                        System.out.println("2 Autobus");
                        int sceltaMezzo = sc.nextInt();
                        TipoMezzo tipoMezzo = null;

                        if (sceltaMezzo == 1) {
                            tipoMezzo = TipoMezzo.TRENO;
                        } else if (sceltaMezzo == 2) {
                            tipoMezzo = TipoMezzo.AUTOBUS;
                        } else {
                            System.err.println("Hai inserito un'opzione non valida.");
                            break;
                        }

                        MezzoDiTrasporto nuovoMezzo = new MezzoDiTrasporto(tipoMezzo, LocalDate.now());
                        mezzoDiTrasportoDAO.save(nuovoMezzo);
                        System.out.println("Nuovo mezzo aggiunto con successo.");

                        break;

                    case 3:
                        utenteDao.mostraTuttiGliUtenti();


                        break;
                    case 4:
                        System.out.println("Insercisci l'id del mezzo da mettere in manutenzione");
                        int idMezzo = sc.nextInt();
                        MezzoDiTrasporto mz = mezzoDiTrasportoDAO.findById(idMezzo);
                        if(mz != null){
                            mz.setInManutenzione();
                            System.out.println("Il mezzo di tipo "+mz.getTipoMezzo()+" con id "+mz.getId()+" è stato correttamente messo in manutenzione");
                        } else {
                            System.err.println("Il mezzo con id "+idMezzo+" non è stato trovato");
                        }
                        break;
                    default:
                        System.err.println("Scelta non valida");
                }

            } else {
                System.err.println("Password errata");
                // inserisci di nuovo la password
            }

        } while (10<0);

        System.out.println("Grazie per aver usato il programma.");
        sc.close();
        em.close();
        emf.close();
    }
}
