package uz.developers.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.codingbat.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    boolean existsByName(String name);

}
