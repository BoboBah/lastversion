package sn.alien.sseapp.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import sn.alien.sseapp.classses.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
