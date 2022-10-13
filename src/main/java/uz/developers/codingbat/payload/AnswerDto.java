package uz.developers.codingbat.payload;

import lombok.Data;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.entity.User;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
public class AnswerDto {

    private String text;

    private Integer taskId;
    private Integer userId;

    private boolean isCorrect;
}
