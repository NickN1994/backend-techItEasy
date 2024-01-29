package nl.novi.techiteasyhw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.novi.techiteasyhw.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
