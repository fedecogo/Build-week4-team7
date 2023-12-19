package team_7.entities;

import team_7.entities.enums.StatoAbbonamento;
import team_7.entities.enums.TipoAbbonamento;
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
    @Column(name="tipo_abbonamento")
    private TipoAbbonamento tipoAbbonamento;
    @Column(name = "stato_abbonamento")
    @Enumerated (EnumType.STRING)
    private StatoAbbonamento statoAbbonamento;
    @ManyToOne
    @JoinColumn(name="tessera_utente",nullable = false)
    private Tessera tesseraUtente;
    @Column(name="durata_abbonamento")
    private Duration durataAbbonamento;
    @ManyToOne
    @JoinColumn(name="tratta", nullable = false)
    private Tratta tratta;
    @ManyToMany(mappedBy="listaAbbonamenti")
    private List<Viaggio> listaViaggi = new ArrayList<Viaggio>();


    public Abbonamento(){}
    public Abbonamento(LocalDate dataEmissione, PuntoVendita puntoVendita, Tessera tesseraUtente , Tratta tratta, TipoAbbonamento tipoAbbonamento) {
        super(dataEmissione, puntoVendita);
        this.tipoAbbonamento = tipoAbbonamento;
        switch (tipoAbbonamento){
            case SETTIMANALE -> this.dataFine = dataEmissione.plusWeeks(1);
            case MENSILE -> this.dataFine = dataEmissione.plusMonths(1);
            case SEMESTRALE -> this.dataFine = dataEmissione.plusMonths(6);
        }
        if(dataFine.isAfter(tesseraUtente.getDataScadenza())){
            System.err.println("Si prega di rinnovare la tessera utente");
        }
        if(LocalDate.now().isAfter(dataFine)){
            this.statoAbbonamento = StatoAbbonamento.SCADUTO;
        } else {
            this.statoAbbonamento = StatoAbbonamento.ATTIVO;
        }
        this.tesseraUtente = tesseraUtente;
        this.durataAbbonamento = Duration.between(dataEmissione,dataFine);
        this.tratta = tratta;
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

    public Tessera getTesseraUtente() {
        return tesseraUtente;
    }

    public void setTesseraUtente(Tessera tesseraUtente) {
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

    public StatoAbbonamento getStatoAbbonamento() {
        return statoAbbonamento;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public List<Viaggio> getListaViaggi() {
        return listaViaggi;
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "dataFine=" + dataFine +
                ", statoAbbonamento=" + statoAbbonamento +
                ", tesseraUtente=" + tesseraUtente +
                ", durataAbbonamento=" + durataAbbonamento +
                ", tratta=" + tratta +
                ", listaViaggi=" + listaViaggi +
                '}';
    }
}
