package sn.alien.sseapp.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import sn.alien.sseapp.classses.TypeSoins;

public interface TypeSoinsRepository extends JpaRepository<TypeSoins, Long> {





    //retoure un type de soins suivant id
    public TypeSoins getById(Long id);





}
