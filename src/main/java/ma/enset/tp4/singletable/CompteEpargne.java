package ma.enset.tp4.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends CompteBancaire {

    @Column(name = "taux_remuneration")
    private Double tauxInteret;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(Double solde, String titulaire, Double tauxInteret) {
        super(solde, titulaire);
        this.tauxInteret = tauxInteret;
    }

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
