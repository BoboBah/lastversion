package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity

public class Assurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ninea;


    private String nomAssurance;

    private String adresse;

    private String telephone;

    private String email;

    private String fax;

    private String codeAssurance;

    @OneToMany(mappedBy = "assurance")
    private Collection<Personne> personnes;

    @OneToMany(mappedBy = "assurance")
    private Collection<Assure> assures;


    @OneToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Long getNinea() {
        return ninea;
    }

    public void setNinea(Long ninea) {
        this.ninea = ninea;
    }

    public String getNomAssurance() {
        return nomAssurance;
    }

    public void setNomAssurance(String nomAssurance) {
        this.nomAssurance = nomAssurance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Collection<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Collection<Personne> personnes) {
        this.personnes = personnes;
    }

    public Assurance() {
    }

    public Assurance(String nomAssurance, String adresse, String telephone, String email, String fax) {
        this.nomAssurance = nomAssurance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.fax = fax;
    }

    public String getCodeAssurance() {
        return codeAssurance;
    }

    public void setCodeAssurance(String codeAssurance) {
        this.codeAssurance = codeAssurance;
    }

    public Collection<Assure> getAssures() {
        return assures;
    }

    public void setAssures(Collection<Assure> assures) {
        this.assures = assures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
