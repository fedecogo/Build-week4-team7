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
    private StatoBiglietto statoBiglietto = StatoBiglietto.NON_VIDIMATO;


    @OneToOne(mappedBy = "biglietto")
    private Vidimazione vidimazione;


    public Biglietto(){}

    public Biglietto(LocalDate data_emissione, TipoTratta tipoTratta, PuntoVendita puntoVendita) {
        super(data_emissione, tipoTratta, puntoVendita);

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
                '}';
    }
}
