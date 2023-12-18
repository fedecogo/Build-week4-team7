package team_7.entities;

import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("abbonamento")
@Table(name = "abbonamenti")

public class Abbonamento extends TitoloDiViaggio{
    @Column(name = "data_fine")
    private LocalDate dataFine;
    @Column(name = "stato_abbonamento")
    @Enumerated (EnumType.STRING)
    private StatoAbbonamento statoAbbonamento;
    @Column(name="tessera_utente")
    private long tesseraUtente;
    @Column(name = "durata_abbonamento")
    private String durataAbbonamento;


    public Abbonamento(){}
    public Abbonamento(LocalDate data_emissione, long idVenditore, TipoTratta tipoTratta, LocalDate dataFine, StatoAbbonamento statoAbbonamento, long tesseraUtente, String durataAbbonamento) {
        super(data_emissione, idVenditore, tipoTratta);
        this.dataFine = dataFine;
        this.statoAbbonamento = statoAbbonamento;
        this.tesseraUtente = tesseraUtente;
        this.durataAbbonamento = durataAbbonamento;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public StatoAbbonamento getStato() {
        return statoAbbonamento;
    }

    public void setStato(StatoAbbonamento statoAbbonamento) {
        this.statoAbbonamento = statoAbbonamento;
    }

    public long getTesseraUtente() {
        return tesseraUtente;
    }

    public void setTesseraUtente(long tesseraUtente) {
        this.tesseraUtente = tesseraUtente;
    }

    public String getDurataAbbonamento() {
        return durataAbbonamento;
    }

    public void setDurataAbbonamento(String durataAbbonamento) {
        this.durataAbbonamento = durataAbbonamento;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "dataFine=" + dataFine +
                ", statoAbbonamento=" + statoAbbonamento +
                ", tesseraUtente=" + tesseraUtente +
                ", durataAbbonamento='" + durataAbbonamento + '\'' +
                '}';
    }
}
