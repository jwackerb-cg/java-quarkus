package org.example.app.general.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemRepository extends JpaRepository<TaskItemEntity, Long> {
}
