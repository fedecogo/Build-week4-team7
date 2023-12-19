package team_7.entities;

import team_7.entities.enums.StatoBiglietto;
import team_7.entities.enums.TipoTratta;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="vidimazioni")
public class Vidimazione {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="data_e_ora")
    private LocalDateTime dataEOra;
    @ManyToOne
    @JoinColumn(name = "id_viaggio", nullable = false)
    private Viaggio viaggio;
    @OneToOne
    @JoinColumn(name = "id_biglietto", nullable = false)
    private Biglietto biglietto;

    public Vidimazione(){}

    public Vidimazione(LocalDateTime dataEOra, Viaggio viaggio, Biglietto biglietto) {

        /*if(dataEOra.isBefore(viaggio.getOrarioPartenza().minusMinutes(30))){
            biglietto.setStatoBiglietto(StatoBiglietto.SCADUTO);
        }*/
        // SE RIMANE TEMPO FACCIAMO QUESTO EXTRA SUI BIGLIETTI SCADUTI
        switch (viaggio.getTratta().getTipoTratta()){
            case BREVE -> {
                this.dataEOra = dataEOra;
                this.viaggio = viaggio;
                this.biglietto = biglietto;
                biglietto.setStatoBiglietto(StatoBiglietto.VIDIMATO);
            }
            case MEDIA ->  {
                if (biglietto.getTipoTratta()==TipoTratta.BREVE){
                    System.err.println("Biglietto non valido!");
                } else {
                    this.dataEOra = dataEOra;
                    this.viaggio = viaggio;
                    this.biglietto = biglietto;
                    biglietto.setStatoBiglietto(StatoBiglietto.VIDIMATO);
                }
            }
            case LUNGA -> {
                if (biglietto.getTipoTratta()==TipoTratta.LUNGA){
                    this.dataEOra = dataEOra;
                    this.viaggio = viaggio;
                    this.biglietto = biglietto;
                    biglietto.setStatoBiglietto(StatoBiglietto.VIDIMATO);
                } else {
                    System.err.println("Biglietto non valido!");
                }
            }
        }
    }

    public LocalDateTime getDataEOra() {
        return dataEOra;
    }

    public long getId() {
        return id;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    @Override
    public String toString() {
        return "Vidimazione{" +
                "id=" + id +
                ", dataEOra=" + dataEOra +
                ", viaggio=" + viaggio +
                ", biglietto=" + biglietto +
                '}';
    }
}
