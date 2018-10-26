package sn.alien.sseapp.dao;





import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.alien.sseapp.classses.Medecin;
import sn.alien.sseapp.classses.User;

import java.util.List;

public interface MedcinRepository extends JpaRepository<Medecin, Long> {


    public List<Medecin> findByNom(String nomMedcin);



    public Page<Medecin> findByNom(String nomMedcin, Pageable pageable);


    //retourne un medcin suivant un id
    //public Medecin getBy

    public Medecin getByIdMedcin(Long idMedecin);



    //----------retourn un medecin suivant un utilisateur-------------------
    public Medecin getByUser(User user);




    @Query("select m from Medecin  m where m.nom like :x")
    public Page<Medecin> chercherMedcinPages(@Param("x") String mc, Pageable pageable);

    @Query("select m from Medecin m where m.nom like :x")

    public List<Medecin> checherMedcin(@Param("x") String mc);







}
