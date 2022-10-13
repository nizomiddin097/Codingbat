package uz.developers.codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.codingbat.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {


}
