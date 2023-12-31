package team_7.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "distributori_automatici")
@DiscriminatorValue("dist-auto")
public class DistributoreAutomatico extends PuntoVendita {
    @Column(name = "in_servizio")
    private boolean inServizio = true;

    public DistributoreAutomatico() {
    }

    public DistributoreAutomatico(String nome, String località) {
        super(nome, località);
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio() {
        this.inServizio = true;
    }

    public void setFuoriServizio() {
        this.inServizio = false;
    }

    @Override
    public String toString() {
        return "Distributore Automatico{" +
                "attualmente in Servizio=" + inServizio +
                " nel " + super.località +
                '}';
    }
}
