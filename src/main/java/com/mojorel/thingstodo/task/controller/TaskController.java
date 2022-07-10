package com.mojorel.thingstodo.task.controller;

import com.mojorel.thingstodo.task.dto.TaskCreationDto;
import com.mojorel.thingstodo.task.dto.TaskDto;
import com.mojorel.thingstodo.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/things-to-do")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> printHello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/task")
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<TaskDto> taskId = taskService.getTasks();

        return ResponseEntity.ok(taskId);
    }

    @PostMapping("/task")
    public ResponseEntity<Long> createTask(@RequestBody TaskCreationDto request) {
        Long taskId = taskService.createTask(request);

        return ResponseEntity.ok(taskId);
    }
}
