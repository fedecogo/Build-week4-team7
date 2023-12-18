package team_7.entities;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tessera")
public class Tessera {
    //attributi

    @Column(name = "id_tessera")
    @Id
    @GeneratedValue
    private long id_tessera;
    private LocalDate data_emissione;
    private LocalDate data_scadenza;
    @OneToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;
    //secondary key    id utente???

    //costruttoria
    public Tessera(){

    }
    public Tessera( LocalDate data_emissione, LocalDate data_scadenza, Utente utente){
        this.data_emissione = data_emissione;
        this.data_scadenza = data_scadenza;
        this.utente = utente;
    }

    //gettere setter

    public long getId_tessera() {
        return id_tessera;
    }

    public LocalDate getData_emissione() {
        return data_emissione;
    }

    public void setData_emissione(LocalDate data_emissione) {
        this.data_emissione = data_emissione;
    }

    public LocalDate getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(LocalDate data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

}
