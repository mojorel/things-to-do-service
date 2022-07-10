package com.mojorel.thingstodo.task.dto;

import lombok.Data;

@Data
public class TaskCreationDto {
    private String name;
    private String description;
    private String owner;
}
