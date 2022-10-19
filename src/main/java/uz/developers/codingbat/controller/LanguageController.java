package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developers.codingbat.entity.Language;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @GetMapping
    public ResponseEntity<List<Language>> getLanguages(){
        List<Language> languages = languageService.getLanguages();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(languages);
    }
    @GetMapping("/{id}")
    public Language getLanguage(@PathVariable Integer id){
        return languageService.getLanguage(id);
    }

    @PostMapping
    public ResponseEntity<Result> addLanguage(@RequestBody Language language){
        Result result = languageService.addLanguage(language);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result> editLanguage(@PathVariable Integer id, @RequestBody Language language){
        Result result = languageService.editLanguage(id, language);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteLanguage(@PathVariable Integer id){
        Result result = languageService.deleteLanguage(id);
        if (result.isSuccess()) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
    }
}
