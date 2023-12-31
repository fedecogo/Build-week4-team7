package team_7.entities;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "orario_partenza")
    private LocalDateTime orarioPartenza;
    @Column(name = "orario_arrivo")
    private LocalDateTime orarioArrivo;
    @Column(name = "durata_effettiva")
    private int durataEffettiva;
    @Column(name = "numero_passeggeri")
    private int numeroPasseggeri = 0;

    @ManyToOne
    @JoinColumn(name = "id_mezzo", nullable = false)
    private MezzoDiTrasporto mezzo;
    @ManyToOne
    @JoinColumn(name = "id_tratta", nullable = false)
    private Tratta tratta;

    @OneToMany(mappedBy = "viaggio")
    private List<Vidimazione> listaDiVidimazioni = new ArrayList<>();

    @ManyToMany
    @JoinTable(
          name =  "viaggi_abbonamenti",
            joinColumns = @JoinColumn(name = "id_viaggio"),
            inverseJoinColumns = @JoinColumn(name = "id_abbonamento")
            )
    private List<Abbonamento> listaAbbonamenti = new ArrayList<Abbonamento>();


    public Viaggio() {
    }

    public Viaggio(LocalDateTime orarioPartenza, LocalDateTime orarioArrivo, MezzoDiTrasporto mezzo, Tratta tratta) {
        this.orarioPartenza = orarioPartenza;
        this.orarioArrivo = orarioArrivo;
        this.mezzo = mezzo;
        this.tratta = tratta;
        this.durataEffettiva = (int) Duration.between(orarioPartenza,orarioArrivo).toMinutes();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getOrarioPartenza() {
        return orarioPartenza;
    }

    public void setOrarioPartenza(LocalDateTime orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    public LocalDateTime getOrarioArrivo() {
        return orarioArrivo;
    }

    public void setOrarioArrivo(LocalDateTime orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
    }

    public int getDurataEffettiva() {
        return durataEffettiva;
    }

    public void setDurataEffettiva(int durataEffettiva) {
        this.durataEffettiva = durataEffettiva;
    }

    public int getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void setNumeroPasseggeri(int numeroPasseggeri) {
        this.numeroPasseggeri = numeroPasseggeri;
    }
    public void aggiornaNumeroPasseggeri(){
        this.numeroPasseggeri = listaDiVidimazioni.size();
    }

    public MezzoDiTrasporto getMezzo() {
        return mezzo;
    }

    public void setMezzo(MezzoDiTrasporto mezzo) {
        this.mezzo = mezzo;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public List<Vidimazione> getListaDiVidimazioni() {
        return listaDiVidimazioni;
    }

    public List<Abbonamento> getListaAbbonamenti() {
        return listaAbbonamenti;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", orarioPartenza=" + orarioPartenza +
                ", orarioArrivo=" + orarioArrivo +
                ", durataEffettiva=" + durataEffettiva +
                ", numeroPasseggeri=" + numeroPasseggeri +
                ", mezzo=" + mezzo +
                ", tratta=" + tratta +
                '}';
    }
}
