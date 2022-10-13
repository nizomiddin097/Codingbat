package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Language;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.LanguageRepository;
import uz.developers.codingbat.service.LanguageService;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    LanguageRepository languageRepository;


    @Override
    public List<Language> getLanguages() {
        return null;
    }

    @Override
    public Language getLanguage(Integer id) {
        return null;
    }

    @Override
    public Result addLanguage(Language language) {
        return null;
    }

    @Override
    public Result editLanguage(Integer id, Language language) {
        return null;
    }

    @Override
    public Result deleteLanguage(Integer id) {
        return null;
    }
}
