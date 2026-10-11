package ma.enset.tp4.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_collaborateurs_dev")
public class Developpeur extends Collaborateur {

    @Column(name = "technologie_principale", length = 50)
    private String langageFavori;

    @Column(name = "prime_projet")
    private Double primeProjet;

    public Developpeur() {
        super();
    }

    public Developpeur(String matricule, String nom, Double salaireBase, String langageFavori, Double primeProjet) {
        super(matricule, nom, salaireBase);
        this.langageFavori = langageFavori;
        this.primeProjet = primeProjet;
    }

    public String getLangageFavori() {
        return langageFavori;
    }

    public void setLangageFavori(String langageFavori) {
        this.langageFavori = langageFavori;
    }

    public Double getPrimeProjet() {
        return primeProjet;
    }

    public void setPrimeProjet(Double primeProjet) {
        this.primeProjet = primeProjet;
    }
}
