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
import java.util.List;
import java.util.Random;
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
        VidimazioneDAO vidimazioneDAO = new VidimazioneDAO(em);

        while (true) {
            System.out.println("Benvenuto alla Galileo Express, come possiamo aiutarti? Scegli un' opzione:");
            System.out.println("1: Crea una Tessera.");
            System.out.println("2: Fai login con l'id della tua tessera e acquista nuovi abbonamenti.");
            System.out.println("3: Compra un biglietto.");
            System.out.println("4: Sali a bordo.");
            System.out.println("5: Esci.");

            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("Per poter creare una tessera è necessario registrarti");
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
                    System.out.println("Vuoi acquistare un abbonamento per un viaggio? si o no. ");
                    String scelta2 = sc.nextLine();
                    if (scelta2.equals("si")) {
                        System.out.println("Dove stai comprando il tuo abbonamento?");
                        puntoVenditaDAO.mostraTuttiIRivenditori();
                        System.out.println("Scelgi l'id del punto vendita");
                        int idPuntoVendita = sc.nextInt();
                        PuntoVendita puntoVenditaScelto = puntoVenditaDAO.findById(idPuntoVendita);
                        System.out.println("Ottima idea ecco le tratte disponibili:");
                        trattaDAO.mostraTutteLeTratte();
                        System.out.println("Scegli l'id del tuo viaggio:");
                        int idViaggioDaAggiungereXUtente =sc.nextInt();
                        Tratta andata = trattaDAO.findById(idViaggioDaAggiungereXUtente);
                        LocalDate oggi = LocalDate.now();

                        System.out.println("Seleziona che tipo di abbonamento vuoi acquistare:");
                        System.out.println("1: Settimanale");
                        System.out.println("2: Mensile");
                        System.out.println("3: Semestrale");
                        int sceltaTipoAbb = sc.nextInt();

                        // dare la possibilita di scegliere il tipo di abbonamneto --> FATTO
                        TipoAbbonamento tipoAbbonamento = null;

                        switch (sceltaTipoAbb){
                            case 1:
                                tipoAbbonamento = TipoAbbonamento.SETTIMANALE;
                                break;
                            case 2:
                                tipoAbbonamento = TipoAbbonamento.MENSILE;
                                break;
                            case 3:
                                tipoAbbonamento = TipoAbbonamento.SEMESTRALE;
                                break;
                            default:
                                System.err.println("Scelta non valida!");
                        }

                        System.out.println("Seleziona il tipo di viaggio: 1 solo andata, 2 andata e ritorno.");
                        int sceltaAR = sc.nextInt();
                        boolean andataRitorno = (sceltaAR == 2);

                        Abbonamento newAbbonamento = new Abbonamento( oggi, puntoVenditaScelto, tesseraNuova, andata, tipoAbbonamento, andataRitorno);
                        abbonamentoDAO.save(newAbbonamento);
                        System.out.println("Perfetto " + nome + " abbiamo creato il tuo abbonamento "+ tipoAbbonamento +" per la "+ trattaDAO.findById(idViaggioDaAggiungereXUtente) + " il tuo abbonamento ha id " + newAbbonamento.getId());
                    }
                    break;

                case 2:
                    System.out.println("Bentornato! Inserisci l'id della tua tessera per effettuare il login.");
                    int idTesseraUtenteLoggato = sc.nextInt();
                    sc.nextLine();

                    Tessera utenteLoggato = tesseraDao.findById(idTesseraUtenteLoggato);

                    if (utenteLoggato != null) {
                        System.out.println("Benvenuto " + utenteLoggato.getUtente().getNome() +". Cosa vuoi fare?");
                        System.out.println("1 Visualizza abbonamenti attivi.");
                        System.out.println("2 Acquista nuovo abbonamento.");
                        System.out.println("3 Torna al menu principale.");

                        int sceltaUtente = sc.nextInt();
                        sc.nextLine();

                        switch (sceltaUtente) {
                            case 1:
                               if(utenteLoggato.getListaDiAbbonamenti().isEmpty()){
                                   System.err.println("Nessun abbonamento associato a questa tessera!");
                               }else {
                                   System.out.println(utenteLoggato.getListaDiAbbonamenti());
                               }
                                break;

                            case 2:
                                System.out.println("Dove stai comprando il tuo abbonamento?");
                                puntoVenditaDAO.mostraTuttiIRivenditori();
                                System.out.println("Scegli l'id del punto vendita.");
                                int idPuntoVendita = sc.nextInt();
                                sc.nextLine();

                                PuntoVendita puntoVenditaScelto = puntoVenditaDAO.findById(idPuntoVendita);

                                System.out.println("Ecco le tratte disponibili:");
                                trattaDAO.mostraTutteLeTratte();
                                System.out.println("Scegli l'id del tuo viaggio:");
                                int idViaggioDaAggiungereXUtente = sc.nextInt();
                                sc.nextLine();

                                Tratta andata = trattaDAO.findById(idViaggioDaAggiungereXUtente);
                                LocalDate oggi = LocalDate.now();

                                System.out.println("Seleziona che tipo di abbonamento vuoi acquistare:");
                                System.out.println("1: Settimanale");
                                System.out.println("2: Mensile");
                                System.out.println("3: Semestrale");
                                int sceltaTipoAbb = sc.nextInt();
                                TipoAbbonamento tipoAbbonamento = null;

                                switch (sceltaTipoAbb){
                                    case 1:
                                        tipoAbbonamento = TipoAbbonamento.SETTIMANALE;
                                        break;
                                    case 2:
                                        tipoAbbonamento = TipoAbbonamento.MENSILE;
                                        break;
                                    case 3:
                                        tipoAbbonamento = TipoAbbonamento.SEMESTRALE;
                                        break;
                                    default:
                                        System.err.println("Scelta non valida!");
                                }
                                System.out.println("Seleziona il tipo di viaggio: 1 solo andata, 2 andata e ritorno.");
                                int sceltaAR = sc.nextInt();
                                boolean andataRitorno = (sceltaAR == 2);

                                String stringOpz = andataRitorno ? "Andata e Ritorno" : "sola Andata";
                                Random rnd = new Random();
                                System.out.println("Perfetto, per il tuo abbonamento " + stringOpz + " sono: " + rnd.nextInt(1,300) + "€");
                                System.out.println("Come vuole pagare? 1 Carta, 2 Contanti.");
                                int sceltaPag = sc.nextInt();
                                Abbonamento newAbbonamento = new Abbonamento(oggi, puntoVenditaScelto, utenteLoggato, andata, tipoAbbonamento, andataRitorno);
                                abbonamentoDAO.save(newAbbonamento);

                                // dare la possibilita di scegliere il tipo di abbonamneto --> FATTO
                                System.out.println("Perfetto, abbiamo creato un nuovo abbonamento " + tipoAbbonamento + " per la " +
                                        trattaDAO.findById(idViaggioDaAggiungereXUtente) + ". Il tuo abbonamento ha id " + newAbbonamento.getId());
                                break;

                            case 3:
                                break;

                            default:
                                System.err.println("Scelta non valida. Torna al menu principale.");
                                break;
                        }
                    } else {
                        System.err.println("Utente non trovato. Torna al menu principale.");
                    }
                    break;

                case 3:

                    //questo è da finire c'è qualche erroew nella riga commentata non sono sicurp sia un viaggio li ma una tratta o frose mi sbagli domani con pi chiareza faccimao tuuto

                    LocalDate oggi = LocalDate.now();
                    System.out.println("Dove stai comprando il tuo biglietto?");
                    puntoVenditaDAO.mostraTuttiIRivenditori();
                    System.out.println("Scegli l'id del punto vendita");
                    int idPuntoVendita = sc.nextInt();
                    PuntoVendita puntoVenditaScelto = puntoVenditaDAO.findById(idPuntoVendita);
                    System.out.println("Benvenuto presso " +puntoVenditaScelto.getNome());
                    System.out.println("Scegli il tipo di biglietto: ");
                    System.out.println("1: Tratta breve");
                    System.out.println("2: Tratta media");
                    System.out.println("3: Tratta lunga");
                    int sceltaTipoTratta = sc.nextInt();
                    TipoTratta tipoTratta = null;
                    // dare la possibilita di scegliere il tipo di abbonamneto
                    switch (sceltaTipoTratta){
                        case 1 ->tipoTratta = TipoTratta.BREVE;
                        case 2 ->tipoTratta = TipoTratta.MEDIA;
                        case 3 ->tipoTratta = TipoTratta.LUNGA;
                        default -> System.err.println("Richiesta non valida!");
                    }

                    Biglietto nuovoBiglietto = new Biglietto(oggi,puntoVenditaScelto,tipoTratta);
                    bigliettoDAO.save(nuovoBiglietto);
                    System.out.println("Hai acquistato un biglietto per una tratta " + nuovoBiglietto.getTipoTratta() + " , ecco l'id del biglietto :"+nuovoBiglietto.getId()+ " Non perderlo e ricordati di vidimarlo!");



                    break;
                case 4:
                    System.out.println("Su quale tratta ti trovi?");
                    trattaDAO.mostraTutteLeTratte();
                    System.out.println("Scegli l'id del tuo viaggio:");
                    int sceltaTratta = sc.nextInt();
                    Tratta myTratta = trattaDAO.findById(sceltaTratta);

                    System.out.println("Sta passando il controllore, qual'è il tuo titolo di viaggio?");
                    System.out.println("1: Biglietto");
                    System.out.println("2: Abbonamento");
                    int sceltaTipoViaggio = sc.nextInt();
                    switch (sceltaTipoViaggio) {
                        case 1 -> {
                            System.out.println("Presenta l'id del tuo biglietto.");
                            int idBiglietto = sc.nextInt();
                            Biglietto biglietto = bigliettoDAO.findById(idBiglietto);
                            if(biglietto.getStatoBiglietto() == StatoBiglietto.VIDIMATO){
                                System.err.println("Il tuo biglietto non è valido, perchè è stato precedentemente vidimato!");
                            }else {
                                switch (myTratta.getTipoTratta()){
                                    case BREVE -> {
                                        biglietto.setStatoBiglietto(StatoBiglietto.VIDIMATO);
                                        System.out.println("Biglietto valido, buon viaggio!");
                                    }
                                    case MEDIA ->  {
                                        if (biglietto.getTipoTratta()==TipoTratta.BREVE){
                                            System.err.println("Biglietto non valido!");
                                        } else {
                                            biglietto.setStatoBiglietto(StatoBiglietto.VIDIMATO);
                                            System.out.println("Biglietto valido, buon viaggio!");
                                        }
                                    }
                                    case LUNGA -> {
                                        if (biglietto.getTipoTratta()==TipoTratta.LUNGA){
                                            biglietto.setStatoBiglietto(StatoBiglietto.VIDIMATO);
                                            System.out.println("Biglietto valido, buon viaggio!");
                                        } else {
                                            System.err.println("Biglietto non valido!");
                                        }
                                    }
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Presenta l'id del tuo abbonamento.");
                            int idAbbonamento = sc.nextInt();
                            Abbonamento abbonamento = abbonamentoDAO.findById(idAbbonamento);
                            if (abbonamento.getDataFine().isBefore(LocalDate.now())) {
                                System.err.println("Il tuo abbonamento è scaduto!");
                            }else{
                                if(abbonamento.isAndataERitorno()){
                                    if(abbonamento.getTratta() == myTratta || (abbonamento.getTratta().getPartenza() == myTratta.getArrivo() && abbonamento.getTratta().getArrivo() == myTratta.getPartenza())){
                                        System.out.println("Il tuo abbonamento è valido, buon viaggio.");
                                    }else {
                                        System.err.println("Il tuo abbonamento non è valido per questa tratta!");
                                    }
                                }else{
                                    if(abbonamento.getTratta() == myTratta){
                                        System.out.println("Il tuo abbonamento è valido, buon viaggio!");
                                    }else{
                                        System.err.println("Il tuo abbonamento non è valido per questa tratta!");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Grazie per aver utilizzato Galileo Express!");
                    em.close();
                    emf.close();
                    System.exit(0);

                default:
                    System.err.println("Scelta non valida. Riprova.");
            }
        }
    }
}
