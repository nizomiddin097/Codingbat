package uz.developers.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Language> getLanguages(){
        return languageService.getLanguages();
    }
    @GetMapping("/{id}")
    public Language getLanguage(@PathVariable Integer id){
        return languageService.getLanguage(id);
    }

    @PostMapping
    public Result addLanguage(@RequestBody Language language){
        return languageService.addLanguage(language);
    }

    @PutMapping("/{id}")
    public Result editLanguage(@PathVariable Integer id, @RequestBody Language language){
        return languageService.editLanguage(id,language);
    }

    @DeleteMapping("/{id}")
    public Result deleteLanguage(@PathVariable Integer id){
        return languageService.deleteLanguage(id);
    }
}
