package team_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import team_7.functionalities.DateParser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("galileo_express");
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LocalDate data1 = LocalDate.of(2020,4,6);
        LocalDate data2 = DateParser.parseDateForItaly("06/04/2020");

        System.out.println(data1);
        System.out.println(data2);

    }
}
