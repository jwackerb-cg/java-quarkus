package org.example.app.task.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskItemRepository extends JpaRepository<TaskItemEntity, Long> {
    @Query("SELECT i FROM TaskItemEntity i WHERE i.list_id <= :ListId")
    List<TaskItemEntity> findAllWithListId(@Param("ListId") Long listId);
}
