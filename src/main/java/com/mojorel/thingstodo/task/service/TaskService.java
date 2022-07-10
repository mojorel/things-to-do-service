package com.mojorel.thingstodo.task.service;

import com.mojorel.thingstodo.task.dto.TaskCreationDto;
import com.mojorel.thingstodo.task.dto.TaskDto;

import java.util.List;

public interface TaskService {

    public Long createTask(TaskCreationDto request);

    List<TaskDto> getTasks();
}
