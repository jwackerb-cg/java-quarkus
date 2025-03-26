package org.example.app.task.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.example.app.task.common.TaskListMapper;
import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.dataaccess.TaskListRepository;

@ApplicationScoped
@Named
@Transactional
public class UcSaveTaskList {

    @Inject
    private TaskListRepository taskListRepo;

    @Inject
    private TaskListMapper taskListMapper;

    public Long save(TaskListEto taskList) {
        TaskListEntity taskListEntity = taskListMapper.toEntity(taskList);
        return taskListRepo.save(taskListEntity).getId();
    }
}
