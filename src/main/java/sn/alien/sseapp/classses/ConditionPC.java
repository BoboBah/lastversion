package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ConditionPC implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    private String Nature;


    private String duree;


    private String date;



    @OneToOne(cascade = CascadeType.ALL, mappedBy = "conditionPC")
    private Traitement traitement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNature() {
        return Nature;
    }

    public void setNature(String nature) {
        Nature = nature;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public ConditionPC() {
    }


    public ConditionPC(String nature, String duree, String date) {
        Nature = nature;
        this.duree = duree;
        this.date = date;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }
}
