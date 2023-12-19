package team_7.entities;

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
    private Viagg
}
