package uz.developers.codingbat.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String text;

    private String solution;

    private String hint;

    private String method;

    private Integer hasStar;

    @ManyToOne
    private Language language;
}
