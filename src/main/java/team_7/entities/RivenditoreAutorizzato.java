package team_7.entities;

import team_7.entities.enums.TipoRivenditore;

import javax.persistence.*;

@Entity
@Table(name = "rivenditore_autorizzato")
@DiscriminatorValue("rivenditore")
public class RivenditoreAutorizzato extends PuntoVendita {
    @Column(name = "tipo_rivenditore")
    @Enumerated(EnumType.STRING)
    private TipoRivenditore tipoRivenditore;

    public RivenditoreAutorizzato() {
    }

    public RivenditoreAutorizzato(String nome, String località, TipoRivenditore tipoRivenditore) {
        super(nome, località);
        this.tipoRivenditore = tipoRivenditore;
    }

    public TipoRivenditore getTipoRivenditore() {
        return tipoRivenditore;
    }

    public void setTipoRivenditore(TipoRivenditore tipoRivenditore) {
        this.tipoRivenditore = tipoRivenditore;
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                "tipoRivenditore=" + tipoRivenditore +
                '}';
    }
}
