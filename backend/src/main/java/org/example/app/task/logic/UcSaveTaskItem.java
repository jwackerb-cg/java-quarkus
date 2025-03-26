package org.example.app.task.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.example.app.task.common.TaskItemMapper;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.TaskItemRepository;

@ApplicationScoped
@Named
@Transactional
public class UcSaveTaskItem {
    @Inject
    TaskItemRepository repo;

    @Inject
    TaskItemMapper mapper;

    public Long save(TaskItemEto item) {
        TaskItemEntity entity = mapper.toEntity(item);
        return repo.save(entity).getId();
    }
}
