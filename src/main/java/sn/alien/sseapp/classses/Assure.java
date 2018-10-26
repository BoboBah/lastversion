package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Assure implements Serializable {

    @Id
    @GeneratedValue
    private Long idAssure;

    private String nomAssure;

    private String prenomAssure;

    private String refPolice;

    private String typeAssure;

    private String societeAssure;

    @ManyToOne
    @JoinColumn(name = "ninea")
    private Assurance assurance;

    @OneToMany(mappedBy = "assure")
    private Collection<Traitement> traitements;

    public Long getIdAssure() {
        return idAssure;
    }

    public void setIdAssure(Long idAssure) {
        this.idAssure = idAssure;
    }

    public String getNomAssure() {
        return nomAssure;
    }

    public void setNomAssure(String nomAssure) {
        this.nomAssure = nomAssure;
    }

    public String getPrenomAssure() {
        return prenomAssure;
    }

    public void setPrenomAssure(String prenomAssure) {
        this.prenomAssure = prenomAssure;
    }

    public String getTypeAssure() {
        return typeAssure;
    }

    public void setTypeAssure(String typeAssure) {
        this.typeAssure = typeAssure;
    }

    public String getSocieteAssure() {
        return societeAssure;
    }

    public void setSocieteAssure(String societeAssure) {
        this.societeAssure = societeAssure;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Assure() {
    }

    public Assure(String nomAssure, String prenomAssure, String typeAssure, String societeAssure, Assurance assurance) {
        this.nomAssure = nomAssure;
        this.prenomAssure = prenomAssure;
        this.typeAssure = typeAssure;
        this.societeAssure = societeAssure;
        this.assurance = assurance;
    }

    public String getRefPolice() {
        return refPolice;
    }

    public void setRefPolice(String refPolice) {
        this.refPolice = refPolice;
    }
}
