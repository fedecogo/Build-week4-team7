package team_7.entities;

import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipologia")
@Table(name = "titoli_di_viaggio")
public abstract class TitoloDiViaggio {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "data_emissione")
    private LocalDate data_emissione;
    @Column(name = "id_venditore")
    private long idVenditore;
    @Enumerated(EnumType.STRING)
    private TipoTratta tipoTratta;

    public TitoloDiViaggio(){}
    public TitoloDiViaggio(LocalDate data_emissione, long idVenditore, TipoTratta tipoTratta) {
        this.data_emissione = data_emissione;
        this.idVenditore = idVenditore;
        this.tipoTratta = tipoTratta;
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

    public long getIdVenditore() {
        return idVenditore;
    }

    public void setIdVenditore(long idVenditore) {
        this.idVenditore = idVenditore;
    }

    public TipoTratta getTipoTratta() {
        return tipoTratta;
    }

    public void setTipoTratta(TipoTratta tipoTratta) {
        this.tipoTratta = tipoTratta;
    }

    @Override
    public String toString() {
        return "TitoloDiViaggio{" +
                "id=" + id +
                ", data_emissione=" + data_emissione +
                ", idVenditore=" + idVenditore +
                ", tipoTratta=" + tipoTratta +
                '}';
    }
}
