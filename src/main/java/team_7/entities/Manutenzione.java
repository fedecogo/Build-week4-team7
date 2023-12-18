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
    private MezzoDiTraporto mezzo;
}
