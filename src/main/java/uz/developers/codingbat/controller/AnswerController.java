package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.codingbat.entity.Answer;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.AnswerDto;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @GetMapping
    public List<Answer> getAnswers(){
        return answerService.getAnswers();
    }
    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Integer id){
        return answerService.getAnswer(id);
    }

    @PostMapping
    public Result addAnswer(@RequestBody AnswerDto answerDto){
        return answerService.addAnswer(answerDto);
    }

    @PutMapping("/{id}")
    public Result editAnswer(@PathVariable Integer id, @RequestBody AnswerDto answerDto){
        return answerService.editAnswer(id,answerDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteAnswer(@PathVariable Integer id){
        return answerService.deleteAnswer(id);
    }
}
