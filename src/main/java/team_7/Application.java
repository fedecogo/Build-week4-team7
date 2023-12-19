package team_7;


import team_7.dao.TesseraDao;
import team_7.dao.UtenteDao;
import team_7.entities.Tessera;
import team_7.entities.Utente;
import team_7.dao.AbbonamentoDAO;
import team_7.dao.BigliettoDAO;
import team_7.entities.Abbonamento;
import team_7.entities.Biglietto;
import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoAbbonamento;
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

        UtenteDao utenteDao = new UtenteDao();
        TesseraDao tesseraDao = new TesseraDao();

        System.out.println("Inserisci i tuoi dati e registrati:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Cognome: ");
        String cognome = sc.nextLine();
        System.out.print("Data di nascita : ");
        String dataStringa = sc.nextLine();
        LocalDate dataNascita = DateParser.parseDateForItaly(dataStringa);
        Utente utenteCreato = new Utente(nome, cognome, dataNascita);
        utenteDao.createUtente(utenteCreato);
        System.out.println("Benvenuto " + utenteCreato.getNome() + "! Sei stato registrato con successo.");


        System.out.print("Vuoi creare una tessera? (si/no): ");
        String risposta = sc.nextLine();

        if (risposta.toLowerCase().equals("si")) {
            LocalDate dataEmissione = LocalDate.now();
            Tessera tessera = new Tessera(dataEmissione, utenteCreato);
            tesseraDao.createTessera(tessera);
            System.out.println("Grande " + utenteCreato.getNome() + "!! hai creato la tua tessera con id: " + tessera.getId_tessera());


        System.out.println("Scegli il tipo di abbonamento che vuoi creare:");
        for (TipoAbbonamento tipo : TipoAbbonamento.values()) {
            System.out.println(tipo.name());
        }
//DA FINIREEEEEEEEEEEEEEEEEE
        } else {
            System.out.println("Hai scelto di non creare una tessera. Fine del processo.");
        }



 /*              List<Tessera> tessereUtente = tesseraDao.getTessereByUtente(utenteRecuperato);


        System.out.println("Utente: " + utenteRecuperato);
        for (Tessera t : tessereUtente) {
            System.out.println("Tessera associata: " + t);
        }
        BigliettoDAO bd = new BigliettoDAO(em);
        AbbonamentoDAO ad = new AbbonamentoDAO(em);

        Biglietto bus = new Biglietto(LocalDate.of(2023,5,8),43435, TipoTratta.MEDIA);
        bd.save(bus);

        Abbonamento treno = new Abbonamento(LocalDate.of(2023,3,28),544,TipoTratta.LUNGA,LocalDate.of(2024,3,27), StatoAbbonamento.ATTIVO,343,"annuale");
        ad.save(treno);*/

        /*System.out.println("Inserisci nome");
        String nome = sc.nextLine();
        System.out.println("Inserisci cognome");
        String cognome = sc.nextLine();
        System.out.println("Inserisci data di nascita");
        String dataStringa = sc.nextLine();
        LocalDate dataNascita = DateParser.parseDateForItaly(dataStringa);
        Utente u1 = new Utente(nome,cognome,dataNascita);
        System.out.println("benvenuto"+u1);
        utenteDao.createUtente(u1);
        System.out.println("Ciao inserisci id utente");
        long idUt = Long.parseLong(sc.nextLine());
        Utente userFromDB = utenteDao.getUtenteById(idUt);
        System.out.println("Benvenuto!"+userFromDB);*/



        em.close();
        emf.close();
    }
}
