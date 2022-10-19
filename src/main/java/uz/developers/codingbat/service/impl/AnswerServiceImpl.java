package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Answer;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.entity.User;
import uz.developers.codingbat.payload.AnswerDto;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.AnswerRepository;
import uz.developers.codingbat.repository.TaskRepository;
import uz.developers.codingbat.repository.UserRepository;
import uz.developers.codingbat.service.AnswerService;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Answer> getAnswers() {
       return answerRepository.findAll();
    }

    @Override
    public Answer getAnswer(Integer id) {
        Optional<Answer> answerOptional = answerRepository.findById(id);
        if (answerOptional.isPresent()) {
            return answerOptional.get();
        }
        return null;
    }

    @Override
    public Result addAnswer(AnswerDto answerDto) {
        Answer savedAnswer = new Answer();
        savedAnswer.setText(answerDto.getText());
        Optional<Task> optionalTask = taskRepository.findById(answerDto.getTaskId());
        if (optionalTask.isEmpty()) {
            return new Result("Task is not found",false);
        }
        Optional<User> optionalUser = userRepository.findById(answerDto.getUserId());
        if (optionalUser.isEmpty()) {
            return new Result("User is not found",false);
        }
        savedAnswer.setTask(optionalTask.get());
        savedAnswer.setUser(optionalUser.get());
        savedAnswer.setCorrect(answerDto.isCorrect());
        answerRepository.save(savedAnswer);
        return new Result("Answer is saved",true);
    }

//    private String text;
//    private Integer taskId;
//    private Integer userId;
//    private boolean isCorrect;

    @Override
    public Result editAnswer(Integer id, AnswerDto answerDto) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isEmpty()) {
            return new Result("Answer is not found",false);
        }
        Answer editedAnswer = optionalAnswer.get();
        editedAnswer.setText(answerDto.getText());
        editedAnswer.setCorrect(answerDto.isCorrect());
        answerRepository.save(editedAnswer);
        return new Result("Answer is edited",true);
    }

    @Override
    public Result deleteAnswer(Integer id) {
        answerRepository.deleteById(id);
        return new Result("Answer is deleted",true);
    }
}
