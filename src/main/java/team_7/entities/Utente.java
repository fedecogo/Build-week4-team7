package team_7.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Utente {
    @Id
    @GeneratedValue
    private long id_utente;



    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

    @OneToOne(mappedBy = "utente")
    private Tessera tessera;


    //costruttori
    public Utente(){

    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }


    //getter
    public long getId() {
        return id_utente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }


    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utente [id=").append(id_utente)
                .append(", nome=").append(nome)
                .append(", cognome=").append(cognome)
                .append(", dataDiNascita=").append(dataDiNascita)
                .append("]");
        return sb.toString();
    }

}
