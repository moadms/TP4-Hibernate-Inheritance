package ma.enset.tp4.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_collaborateurs_chef")
public class ChefProjet extends Collaborateur {

    @Column(name = "certification_pmp")
    private Boolean estCertifiePmp;

    @Column(name = "budget_max_gere")
    private Double budgetMax;

    public ChefProjet() {
        super();
    }

    public ChefProjet(String matricule, String nom, Double salaireBase, Boolean estCertifiePmp, Double budgetMax) {
        super(matricule, nom, salaireBase);
        this.estCertifiePmp = estCertifiePmp;
        this.budgetMax = budgetMax;
    }

    public Boolean getEstCertifiePmp() {
        return estCertifiePmp;
    }

    public void setEstCertifiePmp(Boolean estCertifiePmp) {
        this.estCertifiePmp = estCertifiePmp;
    }

    public Double getBudgetMax() {
        return budgetMax;
    }

    public void setBudgetMax(Double budgetMax) {
        this.budgetMax = budgetMax;
    }
}
