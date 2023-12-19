package team_7.entities;

import team_7.entities.enums.Capolinea;
import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;


@Entity
@Table (name = "tratte")
public class Tratta {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)

    private Capolinea partenza;
    @Enumerated(EnumType.STRING)

    private Capolinea arrivo;
    @Column(name = "durata_media")
    private Duration durataMedia;
    @Enumerated(EnumType.STRING)

    @Column(name = "tipo_tratta")
    private TipoTratta tipoTratta;
    @OneToMany(mappedBy = "tratta")
    private List<Viaggio> listaDiViaggi;
    @OneToMany(mappedBy = "tratta")
    private List<Abbonamento> listaAbbonamenti;
    public Tratta(){}
    public Tratta(Capolinea partenza, Capolinea arrivo, Duration durataMedia) {
        this.partenza = partenza;
        this.arrivo = arrivo;
        this.durataMedia = durataMedia;
        if(durataMedia.compareTo(Duration.ofHours(3)) <=0){ //se durata media è inferiore a 3 allora la tratta è breve
            this.tipoTratta = TipoTratta.BREVE;
        } else if (durataMedia.compareTo(Duration.ofHours(6))<=0) {
            this.tipoTratta = TipoTratta.MEDIA;

        }else {
            this.tipoTratta = TipoTratta.LUNGA;
        }
    }

    public long getId() {
        return id;
    }


    public Capolinea getPartenza() {
        return partenza;
    }


    public Capolinea getArrivo() {
        return arrivo;
    }


    public Duration getDurataMedia() {
        return durataMedia;
    }


    public TipoTratta getTipoTratta() {
        return tipoTratta;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", partenza=" + partenza +
                ", arrivo=" + arrivo +
                ", durataMedia=" + durataMedia +
                ", tipoTratta=" + tipoTratta +
                '}';
    }
}
