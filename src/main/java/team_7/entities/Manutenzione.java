package team_7.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="manutenzioni")
public class Manutenzione {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="data_inizio")
    private LocalDate dataInizio;
    @Column(name="data_fine")
    private LocalDate dataFine;
    @Column(name="descrizione_problema")
    private String descrizioneProblema;
    @ManyToOne
    @JoinColumn(name = "id_mezzo", nullable = false)
    private MezzoDiTrasporto mezzo;
    public Manutenzione(){

    }

    public Manutenzione(LocalDate dataInizio, String descrizioneProblema, MezzoDiTrasporto mezzo) {
        this.dataInizio = dataInizio;
        this.descrizioneProblema = descrizioneProblema;
        this.mezzo = mezzo;
        this.dataFine = dataInizio.plusDays(30);
        mezzo.setInManutenzione();
        if(dataFine.isBefore(LocalDate.now()) || dataFine.isEqual(LocalDate.now())) this.mezzo.setInServizio();
    }

    public long getId() {
        return id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
        if(dataFine.isBefore(LocalDate.now()) || dataFine.isEqual(LocalDate.now())) this.mezzo.setInServizio();
    }

    public String getDescrizioneProblema() {
        return descrizioneProblema;
    }

    public void setDescrizioneProblema(String descrizioneProblema) {
        this.descrizioneProblema = descrizioneProblema;
    }

    public MezzoDiTrasporto getMezzo() {
        return mezzo;
    }

    @Override
    public String toString() {
        return "Manutenzione{" +
                "id=" + id +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", descrizioneProblema='" + descrizioneProblema + '\'' +
                ", mezzo=" + mezzo +
                '}';
    }
}
