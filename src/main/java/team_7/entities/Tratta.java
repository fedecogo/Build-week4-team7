package team_7.entities;

import team_7.entities.enums.Capolinea;
import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.Duration;


@Entity
@Table (name = "tratte")
public class Tratta {
    @Id
    @GeneratedValue
    private long id;

    private Capolinea partenza;
    private Capolinea arrivo;
    @Column(name = "durata_media")
    private Duration durataMedia;
    @Column(name = "tipo_tratta")
    private TipoTratta tipoTratta;


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
