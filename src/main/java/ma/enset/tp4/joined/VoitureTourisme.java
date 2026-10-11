package ma.enset.tp4.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "t_voitures_tourisme")
@PrimaryKeyJoinColumn(name = "id_voiture")
public class VoitureTourisme extends VehiculeService {

    @Column(name = "nombre_places")
    private Integer placesAssises;

    @Column(name = "carburant_type")
    private String typeCarburant;

    public VoitureTourisme() {
        super();
    }

    public VoitureTourisme(String immatriculation, String marque, Double prixAcquisition, Integer placesAssises, String typeCarburant) {
        super(immatriculation, marque, prixAcquisition);
        this.placesAssises = placesAssises;
        this.typeCarburant = typeCarburant;
    }

    public Integer getPlacesAssises() {
        return placesAssises;
    }

    public void setPlacesAssises(Integer placesAssises) {
        this.placesAssises = placesAssises;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }
}
