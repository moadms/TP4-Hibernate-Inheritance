package ma.enset.tp4.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends CompteBancaire {

    @Column(name = "montant_decouvert_autorise")
    private Double decouvertAutorise;

    public CompteCourant() {
        super();
    }

    public CompteCourant(Double solde, String titulaire, Double decouvertAutorise) {
        super(solde, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public Double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(Double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }
}
