package uz.developers.codingbat.payload;

import lombok.Data;
import uz.developers.codingbat.entity.Task;

import javax.persistence.ManyToOne;

@Data
public class ExampleDto {

    private String text;

    private Integer taskId;
}
