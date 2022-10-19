package uz.developers.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.codingbat.entity.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {

    boolean existsByName(String name);
}
