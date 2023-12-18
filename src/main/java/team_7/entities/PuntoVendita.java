package team_7.entities;

import javax.persistence.*;

@Entity
@Table(name = "venditori")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="categoria")

public abstract class PuntoVendita {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String località;

    public PuntoVendita() {

    }

    public PuntoVendita(String nome, String località) {
        this.nome = nome;
        this.località = località;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalità() {
        return località;
    }

    public void setLocalità(String località) {
        this.località = località;
    }

    @Override
    public String toString() {
        return "Venditore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", località='" + località + '\'' +
                '}';
    }
}
