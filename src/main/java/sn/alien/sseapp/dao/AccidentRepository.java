package sn.alien.sseapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.alien.sseapp.classses.Accident;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
