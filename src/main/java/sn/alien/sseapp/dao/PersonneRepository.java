package sn.alien.sseapp.dao;






import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.alien.sseapp.classses.Assurance;
import sn.alien.sseapp.classses.Personne;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Long> {






    //retourne listes personne suivant assurance
    public List<Personne> findByAssurance(Assurance assurance);


    //retourne personne suivant id
    public Personne getByIdPersonne(Long id);


    @Query("select p from Personne p where p.assurance.nomAssurance like :x")
    public Page<Personne> chercherParNomAssurance(@Param("x") String nomAssurance, Pageable pageable);

    //retourne liste personnes suivant id assurance
    @Query("select p from Personne p where p.assurance.ninea= :x")
    public List<Personne> chercherParIdAssurance(@Param("x") Long ninea);

    @Query("select p from Personne p where p.nom like :x")
    public List<Personne> chercherPersonne(@Param("x") String mc);


    @Query("select p from Personne p where p.nom like :x")
    public Page<Personne> pagesPersonne(@Param("x") String mc, Pageable pageable);








}
