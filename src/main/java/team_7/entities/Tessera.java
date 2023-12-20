package team_7.entities;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tessere")
public class Tessera {
    //attributi

    @Column(name = "id_tessera")
    @Id
    @GeneratedValue
    private long id_tessera;
    @Column(name = "data_emissione")
    private LocalDate dataEmissione;
    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;
    @OneToMany(mappedBy = "tesseraUtente")
    private List<Abbonamento> listaDiAbbonamenti = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;
    //secondary key    id utente???

    //costruttoria
    public Tessera(){

    }
    public Tessera( LocalDate dataEmissione, Utente utente){
        this.dataEmissione = dataEmissione;
        this.dataScadenza = dataEmissione.plusYears(1);
        this.utente = utente;
    }

    //gettere setter

    public long getId_tessera() {
        return id_tessera;
    }

    public List<Abbonamento> getListaDiAbbonamenti() {
        return listaDiAbbonamenti;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public Utente getUtente() {
        return utente;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }


    @Override
    public String toString() {
        return "Tessera{" +
                "id_tessera=" + id_tessera +
                ", dataEmissione=" + dataEmissione +
                ", dataScadenza=" + dataScadenza +
                ", listaDiAbbonamenti=" + listaDiAbbonamenti +
                ", utente=" + utente +
                '}';
    }
}

