package ma.enset.tp4.singletable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_comptes_bancaires")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", discriminatorType = DiscriminatorType.STRING, length = 15)
public abstract class CompteBancaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_compte")
    private Long numero;

    @Column(name = "solde_actuel", nullable = false)
    private Double solde;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_ouverture")
    private Date dateCreation;

    @Column(name = "titulaire_compte", length = 100)
    private String titulaire;

    public CompteBancaire() {
        this.dateCreation = new Date();
    }

    public CompteBancaire(Double solde, String titulaire) {
        this();
        this.solde = solde;
        this.titulaire = titulaire;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }
}
