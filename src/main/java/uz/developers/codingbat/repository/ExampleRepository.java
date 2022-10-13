package uz.developers.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.codingbat.entity.Example;

public interface ExampleRepository extends JpaRepository<Example,Integer> {
}
