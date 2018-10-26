package sn.alien.sseapp.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.alien.sseapp.classses.Assurance;
import sn.alien.sseapp.classses.Facture;
import sn.alien.sseapp.classses.Medecin;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {



    //retourne les factures par assurance id
    @Query("select f from Facture f where f.traitement.assure.assurance = :x")
    public List<Facture> factureParAssurance(@Param("x") Assurance assurance);

    //retourne des pages suivant assurance
    @Query("select f from Facture f where f.traitement.assure.assurance = :x")
    public Page<Facture> pagesFacturesParAssurance(@Param("x") Assurance assurance, Pageable pageable);
    //retourne pages factures par medcin

    @Query("select f from Facture f where f.traitement.medecin = :x and f.etat = :y  order by idFacture desc ")
    public Page<Facture> pagesFacturesParMedcin(@Param("x") Medecin m, Pageable pageable,@Param("y") String etat);

    @Query("select count (idFacture) from Facture f where f.traitement.medecin = :x and f.etat = :y")
    public int totalFacture (@Param("x") Medecin m,@Param("y") String etat);

    @Query("select f from Facture f where f.traitement.medecin = :x  order by idFacture desc ")
    public Page<Facture> historiqueParMedcin(@Param("x") Medecin m, Pageable pageable);

    @Query("select count (idFacture) from Facture f where f.traitement.medecin = :x ")
    public int totalHistorique (@Param("x") Medecin m);


   //------------------------------------------------------------------------------------
   @Query("select f from Facture f where f.traitement.medecin = :x")

   public Page<Facture> facturesParMedcin(@Param("x") Medecin m, Pageable pageable);


   //------------factures par assurance et medecin----------------------------------------

    @Query("select f from Facture f where f.traitement.medecin = :x and f.traitement.assure.assurance = :y")

    public Page<Facture> facturesParMedcinAssurance(@Param("x") Medecin m, @Param("y") Assurance assurance, Pageable pageable);


    //----------------------retoure tous les facture par date décroissant
    @Query("select f from Facture f order by f.date desc ")
    public List<Facture> factureParDate();


    //public List<Facture> findAll();

    //retourne tous les pages factures
    public Page<Facture> findAll(Pageable pageable);


    //---------------------retourne une facture par id-------------
    public Facture getByIdFacture(Long idFacture);



    //-------retourne facture suivant etat----------------------
    @Query("select f from Facture f where f.etat= :x")

    public Page<Facture> pagesFactureByEtat(@Param("x") String etat, Pageable pageable);





}
