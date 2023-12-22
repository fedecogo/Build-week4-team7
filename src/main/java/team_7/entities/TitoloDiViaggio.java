package team_7.entities;

import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "data_emissione")
    protected LocalDate data_emissione;

    @ManyToOne
    @JoinColumn(name = "id_punto_vendita", nullable = false)
    protected PuntoVendita puntoVendita;


    public TitoloDiViaggio(){}
    public TitoloDiViaggio(LocalDate data_emissione, PuntoVendita puntoVendita) {
        this.data_emissione = data_emissione;
        this.puntoVendita = puntoVendita;
    }

    public long getId() {
        return id;
    }

    public LocalDate getData_emissione() {
        return data_emissione;
    }

    public void setData_emissione(LocalDate data_emissione) {
        this.data_emissione = data_emissione;
    }

    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }



    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", data_emissione=" + data_emissione +
                ", idVenditore=" + puntoVendita.getId() +
                '}';
    }
}
