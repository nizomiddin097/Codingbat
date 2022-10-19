package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Example;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.ExampleDto;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.ExampleRepository;
import uz.developers.codingbat.repository.TaskRepository;
import uz.developers.codingbat.service.ExampleService;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Autowired
    ExampleRepository exampleRepository;
    @Autowired
    TaskRepository taskRepository;


    @Override
    public List<Example> getExamples() {
       return exampleRepository.findAll();
    }

    @Override
    public Example getExample(Integer id) {
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (optionalExample.isPresent()) {
            return optionalExample.get();
        }
        return null;
    }

    @Override
    public Result addExample(ExampleDto exampleDto) {
//        private String text;
//        private Integer taskId;
        Example savedExample = new Example();
        savedExample.setText(exampleDto.getText());
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTaskId());
        if (optionalTask.isEmpty()) {
            return new Result("Such task is not found",false);
        }
        savedExample.setTask(optionalTask.get());
        exampleRepository.save(savedExample);
        return new Result("Example is saved",true);

    }

    @Override
    public Result editExample(Integer id, ExampleDto exampleDto) {
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (optionalExample.isEmpty()) {
            return new Result("Such example is not found",false);
        }
        Example editedExmple = optionalExample.get();
        editedExmple.setText(exampleDto.getText());
        exampleRepository.save(editedExmple);
        return new Result("Example is edited",true);
    }

    @Override
    public Result deleteExample(Integer id) {
        exampleRepository.deleteById(id);
        return new Result("Example is deleted",true);
    }
}
