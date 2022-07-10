package com.mojorel.thingstodo.task.repository;

import com.mojorel.thingstodo.task.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
