package uz.developers.codingbat.service;

import uz.developers.codingbat.entity.Example;
import uz.developers.codingbat.payload.ExampleDto;
import uz.developers.codingbat.payload.Result;

import java.util.List;

public interface ExampleService {
    List<Example> getExamples();

    Example getExample(Integer id);

    Result addExample(ExampleDto exampleDto);

    Result editExample(Integer id, ExampleDto exampleDto);

    Result deleteExample(Integer id);
}
