package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Medecin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMedcin;

    private String nom;

    private String prenom;

    private String email;

  //  private String telephone;

    private String telephoneFixe;

    private String telephoneMobile;

    private String specialite;

    private String region;

    private Date dateNaissance;


    private Cabinet cabinet;


   // private boolean active;

    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;


    @OneToMany(mappedBy = "medecin")
    private Collection<Traitement> traitements;

    public Long getIdMedcin() {
        return idMedcin;
    }
    public void setIdMedcin(Long idMedcin) {
        this.idMedcin = idMedcin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //public String getTelephone() {
      //  return telephone;
    //}

    //public void setTelephone(String telephone) {
      //  this.telephone = telephone;
    //}

    public Medecin() {
    }


    public String getTelephoneFixe() {
        return telephoneFixe;
    }

    public void setTelephoneFixe(String telephoneFixe) {
        this.telephoneFixe = telephoneFixe;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialité) {
        this.specialite = specialite;
    }

    public Medecin(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    //    this.telephone = telephone;
    }

    public Collection<Traitement> getTraitements() {
        return traitements;
    }

    public void setTraitements(Collection<Traitement> traitements) {
        this.traitements = traitements;
    }


    @OneToOne(cascade = CascadeType.ALL)
    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    //public boolean isActive() {
      //  return active;
    //}

    //public void setActive(boolean active) {
      //  this.active = active;
    //}

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public User getUser() {
        return user;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
