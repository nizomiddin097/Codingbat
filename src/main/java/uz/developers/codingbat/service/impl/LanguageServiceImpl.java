package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Language;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.LanguageRepository;
import uz.developers.codingbat.service.LanguageService;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepository;


    @Override
    public List<Language> getLanguages() {
       return languageRepository.findAll();
    }

    @Override
    public Language getLanguage(Integer id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        }
        return null;
    }

    @Override
    public Result addLanguage(Language language) {
        boolean existsByName = languageRepository.existsByName(language.getName());
        if (existsByName) {
            return new Result("Such language is already exist",false);
        }
        languageRepository.save(language);
        return new Result("Language is saved",true);
    }

    @Override
    public Result editLanguage(Integer id, Language language) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isEmpty()) {
            return new Result("Such language is not found",false);
        }
        Language editedLanguage = optionalLanguage.get();
        editedLanguage.setName(language.getName());
        languageRepository.save(editedLanguage);
        return new Result("Language is edited",true);
    }

    @Override
    public Result deleteLanguage(Integer id) {
        languageRepository.deleteById(id);
        return new Result("Language is deleted",true);
    }
}
