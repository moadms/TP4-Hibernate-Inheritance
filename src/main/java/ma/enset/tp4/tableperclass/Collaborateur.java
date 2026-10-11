package ma.enset.tp4.tableperclass;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Collaborateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_collaborateur")
    private Long id;

    @Column(name = "matricule_rh", nullable = false, length = 30)
    private String matricule;

    @Column(name = "nom_prenom", nullable = false, length = 100)
    private String nom;

    @Column(name = "remuneration_base")
    private Double salaireBase;

    public Collaborateur() {
    }

    public Collaborateur(String matricule, String nom, Double salaireBase) {
        this.matricule = matricule;
        this.nom = nom;
        this.salaireBase = salaireBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(Double salaireBase) {
        this.salaireBase = salaireBase;
    }
}
