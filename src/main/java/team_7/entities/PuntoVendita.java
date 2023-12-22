package team_7.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "punti_vendita")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="categoria")

public abstract class PuntoVendita {
    @Id
    @GeneratedValue
    private long id;
    protected String nome;
    protected String località;
    @OneToMany(mappedBy = "puntoVendita")
    protected List<TitoloDiViaggio> listaTitoliDiViaggioEmessi = new ArrayList<>();

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

    public List<TitoloDiViaggio> getListaTitoliDiViaggioEmessi() {
        return listaTitoliDiViaggioEmessi;
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
