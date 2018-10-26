package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class Facture implements Serializable {

   //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "idFacture")
    //private Long idFacture;


    @Id
    @GeneratedValue
    private Long idFacture;

    //@Id
    //@OneToOne()
    //@JoinColumn(name = "idTraitement")
    @OneToOne
    @JoinColumn(name = "idTraitement")
    private Traitement traitement;



    private Date date;

    private String etat;


    private boolean signature;



    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Facture() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


  //  public Long getIdFacture() {
    //    return idFacture;
    //}

    //public void setIdFacture(Long idFacture) {
      //  this.idFacture = idFacture;
    //}



    public void valider()
    {
        this.setEtat("Valider");
    }

    public void Rejet()
    {
        this.setEtat("Rejetée");
    }

    public void EnCours()
    {
        this.setEtat("En Cours");
    }

    public boolean isSignature() {
        return signature;
    }

    public void setSignature(boolean signature) {
        this.signature = signature;
    }
}
