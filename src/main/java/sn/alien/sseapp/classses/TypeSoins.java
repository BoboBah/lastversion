package sn.alien.sseapp.classses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class TypeSoins implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String designation;

    private double montant;

    private double montantHonoraire;

    @OneToMany(mappedBy = "typeSoins")
    private Collection<Traitement> traitements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantHonoraire() {
        return montantHonoraire;
    }

    public void setMontantHonoraire(double montantHonoraire) {
        this.montantHonoraire = montantHonoraire;
    }

    public TypeSoins() {
    }

    public TypeSoins(String designation, double montant, double montantHonoraire) {
        this.designation = designation;
        this.montant = montant;
        this.montantHonoraire = montantHonoraire;
    }

    public Collection<Traitement> getTraitements() {
        return traitements;
    }

    public void setTraitements(Collection<Traitement> traitements) {
        this.traitements = traitements;
    }

}
