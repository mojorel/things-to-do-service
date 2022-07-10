package com.mojorel.thingstodo.task.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private String owner;
    private String status;
    private LocalDateTime createdTad;
    private LocalDateTime modifiedTad;
}
