package uz.developers.codingbat.service;

import uz.developers.codingbat.entity.Task;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.payload.TaskDto;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    Task getTask(Integer id);

    Result addTask(TaskDto taskDto);

    Result editTask(Integer id, TaskDto taskDto);

    Result deleteTask(Integer id);
}
