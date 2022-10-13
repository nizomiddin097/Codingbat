package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;
import uz.developers.codingbat.repository.TaskRepository;
import uz.developers.codingbat.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;


    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public Task getTask(Integer id) {
        return null;
    }

    @Override
    public Result addTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public Result editTask(Integer id, TaskDto taskDto) {
        return null;
    }

    @Override
    public Result deleteTask(Integer id) {
        return null;
    }
}
