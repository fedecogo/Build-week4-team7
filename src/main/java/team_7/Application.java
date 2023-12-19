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

        UtenteDao utenteDao = new UtenteDao();
        TesseraDao tesseraDao = new TesseraDao();

        Utente utente = new Utente("trio", "Rossi", LocalDate.of(1990, 5, 15));
        /*utenteDao.createUtente(utente);
//        Utente utenteRecuperato = utenteDao.getUtenteById(1);
        Utente utenteRecuperato = utenteDao.getUtenteById(1);

        Tessera tessera = new Tessera( LocalDate.of(2002,03,03) , LocalDate.of(2002,03,03) , utenteRecuperato);
        tesseraDao.createTessera(tessera);

        List<Tessera> tessereUtente = tesseraDao.getTessereByUtente(utenteRecuperato);


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
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Inserisci nome");
        String nome = sc.nextLine();
        System.out.println("Inserisci cognome");
        String cognome = sc.nextLine();
        System.out.println("Inserisci data di nascita");
        String dataStringa = sc.nextLine();
        LocalDate dataNascita = DateParser.parseDateForItaly(dataStringa);
        Utente u1 = new Utente(nome,cognome,dataNascita);
        System.out.println("benvenuto"+u1);
        utenteDao.createUtente(u1);*/
        System.out.println("Ciao inserisci id utente");
        long idUt = Long.parseLong(sc.nextLine());
        Utente userFromDB = utenteDao.getUtenteById(idUt);
        System.out.println("Benvenuto!"+userFromDB);
        em.close();
        emf.close();
    }
}
