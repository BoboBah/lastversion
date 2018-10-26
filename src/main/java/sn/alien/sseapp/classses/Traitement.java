package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Traitement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTraitement;

    @ManyToOne
    @JoinColumn(name = "idTypeSoins")
    private TypeSoins typeSoins;


    private Date date;




    @OneToOne(cascade = CascadeType.ALL, mappedBy = "traitement")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "idMedecin")

    private Medecin medecin;



    @OneToOne
    @JoinColumn(name = "idAccident")
    private Accident accident;

   // @OneToOne
    //@JoinColumn(name = "idUser")
    //private User user;


    @OneToOne
    @JoinColumn(name = "idConditionPC")
    private ConditionPC conditionPC;






    @ManyToOne
    @JoinColumn(name = "idBeneficiare")
    private Beneficiaire beneficiaire;



    @ManyToOne
    @JoinColumn(name = "idAssure")
    private Assure assure;






    public Long getIdTraitement() {
        return idTraitement;
    }

    public void setIdTraitement(Long idTraitement) {
        this.idTraitement = idTraitement;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public TypeSoins getTypeSoins() {
        return typeSoins;
    }

    public void setTypeSoins(TypeSoins typeSoins) {
        this.typeSoins = typeSoins;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }






    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }



    public Traitement() {
    }



    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Assure getAssure() {
        return assure;
    }

    public void setAssure(Assure assure) {
        this.assure = assure;
    }


    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }


    public ConditionPC getConditionPC() {
        return conditionPC;
    }

    public void setConditionPC(ConditionPC conditionPC) {
        this.conditionPC = conditionPC;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
