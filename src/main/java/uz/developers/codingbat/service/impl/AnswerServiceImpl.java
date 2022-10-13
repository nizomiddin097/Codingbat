package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.repository.AnswerRepository;

@Service
public class AnswerServiceImpl {
    @Autowired
    AnswerRepository answerRepository;
}
