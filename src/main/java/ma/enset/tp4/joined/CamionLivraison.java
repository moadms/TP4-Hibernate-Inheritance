package ma.enset.tp4.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_camions_livraison")
@PrimaryKeyJoinColumn(name = "id_camion")
public class CamionLivraison extends VehiculeService {

    @Column(name = "charge_maximale_tonnes")
    private Double chargeUtile;

    @Column(name = "nombre_essieux")
    private Integer essieux;

    public CamionLivraison() {
        super();
    }

    public CamionLivraison(String immatriculation, String marque, Double prixAcquisition, Double chargeUtile, Integer essieux) {
        super(immatriculation, marque, prixAcquisition);
        this.chargeUtile = chargeUtile;
        this.essieux = essieux;
    }

    public Double getChargeUtile() {
        return chargeUtile;
    }

    public void setChargeUtile(Double chargeUtile) {
        this.chargeUtile = chargeUtile;
    }

    public Integer getEssieux() {
        return essieux;
    }

    public void setEssieux(Integer essieux) {
        this.essieux = essieux;
    }
}
