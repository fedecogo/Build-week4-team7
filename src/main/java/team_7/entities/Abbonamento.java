package team_7.entities;

import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "abbonamenti")

public class Abbonamento extends TitoloDiViaggio{
    @Column(name = "data_fine")
    private LocalDate dataFine;
    @Column(name = "stato_abbonamento")
    @Enumerated (EnumType.STRING)
    private StatoAbbonamento statoAbbonamento;
    @Column(name="tessera_utente")
    private long tesseraUtente;
    @Column(name="durata_abbonamento")
    private Duration durataAbbonamento;
    @ManyToMany(mappedBy="listaAbbonamenti")
    private List<Viaggio> listaViaggi = new ArrayList<Viaggio>();


    public Abbonamento(){}
    public Abbonamento(LocalDate data_emissione, TipoTratta tipoTratta, PuntoVendita puntoVendita, StatoAbbonamento statoAbbonamento, long tesseraUtente ) {
        super(data_emissione, tipoTratta, puntoVendita);
        this.dataFine = data_emissione.plusYears(1);
        this.statoAbbonamento = statoAbbonamento;
        this.tesseraUtente = tesseraUtente;
        this.durataAbbonamento = Duration.between(data_emissione,dataFine);
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

    public Duration getDurataAbbonamento() {
        return durataAbbonamento;
    }

    public void setDurataAbbonamento(Duration durataAbbonamento) {
        this.durataAbbonamento = durataAbbonamento;
    }

    public Duration getDurataResidua() {
     return Duration.between(LocalDate.now(), dataFine)  ;
    }
    @Override
    public String toString() {
        return "Abbonamento{" +
                "dataFine=" + dataFine +
                ", statoAbbonamento=" + statoAbbonamento +
                ", tesseraUtente=" + tesseraUtente +
                ", durataAbbonamento='" + durataAbbonamento  +
                ", durata residua =" + getDurataResidua()  +'\'' +
                '}';
    }
}
