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
    public Tessera( LocalDate data_emissione, LocalDate data_scadenza, Utente utente){
        this.dataEmissione = data_emissione;
        this.dataScadenza = data_scadenza;
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

    public LocalDate getData_emissione() {
        return dataEmissione;
    }

    public void setData_emissione(LocalDate data_emissione) {
        this.dataEmissione = data_emissione;
    }

    public LocalDate getData_scadenza() {
        return dataScadenza;
    }

    public void setData_scadenza(LocalDate data_scadenza) {
        this.dataScadenza = data_scadenza;
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

