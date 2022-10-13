package uz.developers.codingbat.payload;

import lombok.Data;
import uz.developers.codingbat.entity.Language;

import javax.persistence.ManyToOne;

@Data
public class TaskDto {

    private String name;
    private String text;
    private String solution;
    private String hint;
    private String method;
    private Integer hasStar;

    private Integer languageId;
}
