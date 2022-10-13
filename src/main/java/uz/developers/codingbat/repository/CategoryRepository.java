package uz.developers.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.codingbat.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
