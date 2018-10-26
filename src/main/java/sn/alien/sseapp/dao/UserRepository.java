package sn.alien.sseapp.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import sn.alien.sseapp.classses.User;

public interface UserRepository extends JpaRepository<User, String> {
}
