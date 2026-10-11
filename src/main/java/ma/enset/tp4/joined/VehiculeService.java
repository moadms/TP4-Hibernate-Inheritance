package ma.enset.tp4.joined;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_vehicules_parc")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VehiculeService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicule")
    private Long id;

    @Column(name = "immatriculation", unique = true, nullable = false, length = 20)
    private String immatriculation;

    @Column(name = "marque_constructeur", length = 50)
    private String marque;

    @Column(name = "prix_acquisition")
    private Double prixAcquisition;

    public VehiculeService() {
    }

    public VehiculeService(String immatriculation, String marque, Double prixAcquisition) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.prixAcquisition = prixAcquisition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Double getPrixAcquisition() {
        return prixAcquisition;
    }

    public void setPrixAcquisition(Double prixAcquisition) {
        this.prixAcquisition = prixAcquisition;
    }
}
