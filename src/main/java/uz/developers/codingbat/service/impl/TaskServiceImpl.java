package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Language;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.repository.LanguageRepository;
import uz.developers.codingbat.repository.TaskRepository;
import uz.developers.codingbat.service.TaskService;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    LanguageRepository languageRepository;


    @Override
    public List<Task> getTasks() {
       return taskRepository.findAll();
    }

    @Override
    public Task getTask(Integer id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        }
        return null;
    }

    @Override
    public Result addTask(TaskDto taskDto) {
        boolean existsByName = taskRepository.existsByName(taskDto.getName());
        if (existsByName) {
            return new Result("Such name already exist",false);
        }
        Optional<Language> optionalLanguage = languageRepository.findById(taskDto.getLanguageId());
        if (optionalLanguage.isEmpty()) {
            return new Result("Such language is not found",false);
        }
        Task savedTask = new Task();
        savedTask.setName(taskDto.getName());
        savedTask.setText(taskDto.getText());
        savedTask.setSolution(taskDto.getSolution());
        savedTask.setHint(taskDto.getHint());
        savedTask.setMethod(taskDto.getMethod());
        savedTask.setHasStar(taskDto.getHasStar());
        savedTask.setLanguage(optionalLanguage.get());

        taskRepository.save(savedTask);
        return new Result("Task is saved",true);
    }

    @Override
    public Result editTask(Integer id, TaskDto taskDto) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            return new Result("Task is not found",false);
        }
        Task editedTask = optionalTask.get();
        editedTask.setName(taskDto.getName());
        editedTask.setText(taskDto.getText());
        editedTask.setSolution(taskDto.getSolution());
        editedTask.setHint(taskDto.getHint());
        editedTask.setMethod(taskDto.getMethod());
        editedTask.setHasStar(taskDto.getHasStar());
        taskRepository.save(editedTask);
        return new Result("Task is edited",true);

    }

    @Override
    public Result deleteTask(Integer id) {
        taskRepository.deleteById(id);
        return new Result("Task is deleted",true);
    }
}
