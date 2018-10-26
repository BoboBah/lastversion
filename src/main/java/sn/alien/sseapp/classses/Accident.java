package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Accident implements Serializable {


    @Id
    @GeneratedValue
    private Long idAccident;

    private String tiersResponsable;

    private String temoins;

    private String causes;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "accident")
    private Traitement traitement;


    public Long getIdAccident() {
        return idAccident;
    }

    public void setIdAccident(Long idAccident) {
        this.idAccident = idAccident;
    }

    public String getTiersResponsable() {
        return tiersResponsable;
    }

    public void setTiersResponsable(String tiersResponsable) {
        this.tiersResponsable = tiersResponsable;
    }

    public String getTemoins() {
        return temoins;
    }

    public void setTemoins(String temoins) {
        this.temoins = temoins;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public Accident() {
    }


    public Accident(String tiersResponsable, String temoins, String causes) {
        this.tiersResponsable = tiersResponsable;
        this.temoins = temoins;
        this.causes = causes;
    }


    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }
}
