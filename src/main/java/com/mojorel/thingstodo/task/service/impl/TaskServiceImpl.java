package com.mojorel.thingstodo.task.service.impl;

import com.mojorel.thingstodo.task.dto.TaskCreationDto;
import com.mojorel.thingstodo.task.dto.TaskDto;
import com.mojorel.thingstodo.task.entity.TaskEntity;
import com.mojorel.thingstodo.task.repository.TaskRepository;
import com.mojorel.thingstodo.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Long createTask(TaskCreationDto request) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName(request.getName());
        taskEntity.setDescription(request.getDescription());
        taskEntity.setOwner(request.getOwner());
        taskEntity.setStatus("New");
        taskEntity.setCreatedTad(LocalDateTime.now());

        taskEntity = taskRepository.save(taskEntity);

        return taskEntity.getId();
    }

    @Override
    public List<TaskDto> getTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        List<TaskDto> taskDtos = new ArrayList<>();

        for(TaskEntity entity : taskEntities) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(entity.getId());
            taskDto.setName(entity.getName());
            taskDto.setDescription(entity.getDescription());
            taskDto.setOwner(entity.getOwner());
            taskDto.setStatus(entity.getStatus());
            taskDto.setCreatedTad(entity.getCreatedTad());
            taskDto.setModifiedTad(entity.getModifiedTad());

            taskDtos.add(taskDto);
        }

        return taskDtos;
    }
}
