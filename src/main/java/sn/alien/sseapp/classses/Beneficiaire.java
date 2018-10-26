package sn.alien.sseapp.classses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Beneficiaire implements Serializable {


    @Id
    @GeneratedValue
    private Long idBeneficaire;

    private String refPolice;

    private String nom;

    private String prenom;

    private String dateNaissance;


    private String adresse;


    @OneToMany(mappedBy = "beneficiaire")
    private Collection<Traitement> traitements;




    public Long getIdBeneficaire() {
        return idBeneficaire;
    }

    public void setIdBeneficaire(Long idBeneficaire) {
        this.idBeneficaire = idBeneficaire;
    }

    public String getRefPolice() {
        return refPolice;
    }

    public void setRefPolice(String refPolice) {
        this.refPolice = refPolice;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Beneficiaire() {
    }

    public Beneficiaire(String refPolice, String nom, String prenom, String dateNaissance) {
        this.refPolice = refPolice;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }


    public Collection<Traitement> getTraitements() {
        return traitements;
    }

    public void setTraitements(Collection<Traitement> traitements) {
        this.traitements = traitements;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
