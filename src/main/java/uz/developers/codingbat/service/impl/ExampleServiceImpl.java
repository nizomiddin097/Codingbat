package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Example;
import uz.developers.codingbat.payload.ExampleDto;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.ExampleRepository;
import uz.developers.codingbat.service.ExampleService;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    ExampleRepository exampleRepository;


    @Override
    public List<Example> getExamples() {
        return null;
    }

    @Override
    public Example getExample(Integer id) {
        return null;
    }

    @Override
    public Result addExample(ExampleDto exampleDto) {
        return null;
    }

    @Override
    public Result editExample(Integer id, ExampleDto exampleDto) {
        return null;
    }

    @Override
    public Result deleteExample(Integer id) {
        return null;
    }
}
