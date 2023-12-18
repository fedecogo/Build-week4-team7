package team_7.entities;

import team_7.entities.enums.TipoMezzo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "mezzi_di_trasporto")
public class MezzoDiTraporto {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="tipo_mezzo")
    private TipoMezzo tipoMezzo;
    @Column(name="data_acquisto")
    private LocalDate dataAcquisto;
    @Column(name="in_servizio")
    private boolean inServizio = true;
    private int capienza;
    @OneToMany(mappedBy = "mezzo")
    List<Manutenzione> listaManutenzione;

    public MezzoDiTraporto(){

    }

    public MezzoDiTraporto(TipoMezzo tipoMezzo, LocalDate dataAcquisto) {
        this.tipoMezzo = tipoMezzo;
        this.dataAcquisto = dataAcquisto;
        switch (tipoMezzo){
            case TRENO -> this.capienza = 200;
            case AUTOBUS -> this.capienza = 50;
        }
    }

    public long getId() {
        return id;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }


    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }

    public int getCapienza() {
        return capienza;
    }

    public List<Manutenzione> getListaManutenzione() {
        return listaManutenzione;
    }

    @Override
    public String toString() {
        return "MezzoDiTraporto{" +
                "id=" + id +
                ", tipoMezzo=" + tipoMezzo +
                ", dataAcquisto=" + dataAcquisto +
                ", inServizio=" + inServizio +
                ", capienza=" + capienza +
                '}';
    }
}
