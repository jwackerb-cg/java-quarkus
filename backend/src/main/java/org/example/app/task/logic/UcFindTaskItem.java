package org.example.app.task.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.example.app.task.common.TaskItemMapper;
import org.example.app.task.dataaccess.TaskItemRepository;

@ApplicationScoped
@Named
@Transactional
public class UcFindTaskItem {
    @Inject
    private TaskItemRepository repo;
    @Inject
    TaskItemMapper mapper;

    public TaskItemEto findById(Long id) {
        var entityOpt = repo.findById(id);
        return entityOpt.map(entity -> mapper.toEto(entity)).orElseThrow();
    }
}
