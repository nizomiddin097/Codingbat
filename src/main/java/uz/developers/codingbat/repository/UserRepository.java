package uz.developers.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.codingbat.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);
}
