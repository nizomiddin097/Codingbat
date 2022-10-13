package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Answer;
import uz.developers.codingbat.payload.AnswerDto;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.AnswerRepository;
import uz.developers.codingbat.service.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> getAnswers() {
        return null;
    }

    @Override
    public Answer getAnswer(Integer id) {
        return null;
    }

    @Override
    public Result addAnswer(AnswerDto answerDto) {
        return null;
    }

    @Override
    public Result editAnswer(Integer id, AnswerDto answerDto) {
        return null;
    }

    @Override
    public Result deleteAnswer(Integer id) {
        return null;
    }
}
