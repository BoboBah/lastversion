package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPersonne;

    private String nom;

    private String prenom;


    private String adresse;

    @ManyToOne
    @JoinColumn(name = "ninea")
    private Assurance assurance;

   // @OneToMany(mappedBy = "personne")
    //private Collection<Traitement> traitements;

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Assurance getAssurance() {
        return assurance;
    }

    public void setAssurance(Assurance assurance) {
        this.assurance = assurance;
    }

    public Personne() {
    }

    public Personne(String nom, String prenom, String adresse, Assurance assurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.assurance = assurance;
    }

    //public Collection<Traitement> getTraitements() {
      //  return traitements;
    //}

    //public void setTraitements(Collection<Traitement> traitements) {
      //  this.traitements = traitements;
    //}
}
