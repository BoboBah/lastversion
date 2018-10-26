package sn.alien.sseapp.dao;






import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.alien.sseapp.classses.Traitement;

import java.util.List;

public interface TraitementRepository extends JpaRepository<Traitement, Long> {




    //retourne tous les traitement suivant le medcin
    @Query("select t from Traitement t where t.medecin.idMedcin = :x")
    public List<Traitement> chercherTraitementByMedcin(@Param("x") Long idMedcin);


    //retourne des pages de traitement suivant le medcin
    @Query("select t from Traitement t where t.medecin.idMedcin = :x")
    public Page<Traitement> chercherTraitementByMedcin(@Param("x") Long idMedecin, Pageable pageable);

    //retourne un traitement par id medcin
    public Traitement getByIdTraitement(int id);

    public Traitement getByIdTraitement(Long id);

    //retourne tous les traitement par date décroissant
    @Query("select t from Traitement t order by t.date desc ")
    public Page<Traitement> traitementParDate(Pageable pageable);







}
