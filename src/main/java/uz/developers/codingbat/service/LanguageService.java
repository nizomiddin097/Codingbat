package uz.developers.codingbat.service;

import uz.developers.codingbat.entity.Language;
import uz.developers.codingbat.payload.Result;

import java.util.List;

public interface LanguageService {

    List<Language> getLanguages();

    Language getLanguage(Integer id);

    Result addLanguage(Language language);

    Result editLanguage(Integer id, Language language);

    Result deleteLanguage(Integer id);
}
