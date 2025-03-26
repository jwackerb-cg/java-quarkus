package org.example.app.task.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskListEntity, Long> {

    @Query("SELECT i.taskList FROM TaskItemEntity i WHERE i.deadline <= :dueDate")
    List<TaskListEntity> findAllWithDueItems(@Param("dueDate") LocalDateTime dueDate);
}
