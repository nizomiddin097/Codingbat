package uz.developers.codingbat.service;

import uz.developers.codingbat.entity.Answer;
import uz.developers.codingbat.payload.AnswerDto;
import uz.developers.codingbat.payload.Result;

import java.util.List;

public interface AnswerService {
    List<Answer> getAnswers();

    Answer getAnswer(Integer id);

    Result addAnswer(AnswerDto answerDto);

    Result editAnswer(Integer id, AnswerDto answerDto);

    Result deleteAnswer(Integer id);
}
