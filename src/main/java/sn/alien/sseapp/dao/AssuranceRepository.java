package sn.alien.sseapp.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.alien.sseapp.classses.Assurance;
import sn.alien.sseapp.classses.User;

import java.util.List;

public interface AssuranceRepository extends JpaRepository<Assurance, Long> {


    //trouve un assurance suivant le nom

    public List<Assurance> findByNomAssurance(String nomAssurance);


    public Page<Assurance> findByNomAssurance(String nomAssurance, Pageable pageable);




     //retourne un assurance suivant le ninea
    public Assurance getByNinea(int ninea);

    public Assurance getByNinea(Long ninea);

    //retourne un assurance suivant un nom

    public Assurance getByNomAssurance(String nomAssurance);

    //retourne une liste
    @Query("select a from Assurance  a where a.nomAssurance like :x")
    public Page<Assurance> chercherAssurance(@Param("x") String mc, Pageable pageable);


    //retourne un liste
    @Query("select a from Assurance  a where a.nomAssurance like :x")
    public List<Assurance> chercherAssurance(@Param("x") String mc);


    //----------retourne l'assurance suivant un user-------------

    public Assurance getByUser(User user);









}
