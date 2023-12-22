package team_7.entities;

import team_7.entities.enums.StatoBiglietto;
import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
public class Biglietto extends TitoloDiViaggio {
    @Column(name = "stato")
    @Enumerated(EnumType.STRING)
    private StatoBiglietto statoBiglietto;
    @Enumerated(EnumType.STRING)
    private TipoTratta tipoTratta;


    @OneToOne(mappedBy = "biglietto")
    private Vidimazione vidimazione;


    public Biglietto(){}

    public Biglietto(LocalDate data_emissione,PuntoVendita puntoVendita,TipoTratta tipoTratta) {
        super(data_emissione,puntoVendita);
        this.tipoTratta = tipoTratta;
        this.statoBiglietto = StatoBiglietto.NON_VIDIMATO;

    }

    public TipoTratta getTipoTratta() {
        return tipoTratta;
    }

    public void setTipoTratta(TipoTratta tipoTratta) {
        this.tipoTratta = tipoTratta;
    }

    public Vidimazione getVidimazione() {
        return vidimazione;
    }



    public StatoBiglietto getStatoBiglietto() {
        return statoBiglietto;
    }

    public void setStatoBiglietto(StatoBiglietto statoBiglietto) {
        this.statoBiglietto = statoBiglietto;
    }

    @Override
    public String toString() {
        return "Biglietto{" +
                "statoBiglietto=" + statoBiglietto +
                ", tipoTratta=" + tipoTratta +
                ", vidimazione=" + vidimazione +
                '}';
    }
}
