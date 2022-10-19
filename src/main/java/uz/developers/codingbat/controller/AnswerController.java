package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Answer>> getAnswers() {
        List<Answer> answers = answerService.getAnswers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(answers);
    }

    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Integer id) {
        return answerService.getAnswer(id);
    }

    @PostMapping
    public ResponseEntity<Result> addAnswer(@RequestBody AnswerDto answerDto) {
        Result result = answerService.addAnswer(answerDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editAnswer(@PathVariable Integer id, @RequestBody AnswerDto answerDto) {
        Result result = answerService.editAnswer(id,answerDto);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Integer id) {
        Result result = answerService.deleteAnswer(id);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }
    }

