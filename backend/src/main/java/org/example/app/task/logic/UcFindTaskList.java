package org.example.app.task.logic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.example.app.task.common.TaskItemMapper;
import org.example.app.task.common.TaskListMapper;
import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.dataaccess.TaskItemRepository;
import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.dataaccess.TaskListRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Named
@Transactional
public class UcFindTaskList {

    @Inject
    private TaskListRepository taskListRepo;

    @Inject
    private TaskItemRepository taskItemRepo;

    @Inject
    private TaskListMapper taskListMapper;

    @Inject
    private TaskItemMapper taskItemMapper;

    public TaskListEto findById(Long itemId) {
        Optional<TaskListEntity> listEntityOpt = taskListRepo.findById(itemId);
        return listEntityOpt.map(list -> taskListMapper.toEto(list)).orElseThrow();
    }

    public List<TaskListEto> findAll() {
        List<TaskListEntity> lists = taskListRepo.findAll();
        return lists.stream().map(list -> taskListMapper.toEto(list)).collect(Collectors.toList());
    }

    public List<TaskListEto> findAllWithOverdueItems() {
        List<TaskListEntity> lists = taskListRepo.findAllWithDueItems(LocalDateTime.now());
        return lists.stream().map(list -> taskListMapper.toEto(list)).collect(Collectors.toList());
    }

    public TaskListCto findWithItems(Long id) {
        Optional<TaskListEntity> taskList = this.taskListRepo.findById(id);
        if (taskList.isEmpty()) {
            return null;
        }
        TaskListCto cto = new TaskListCto();
        TaskListEntity taskListEntity = taskList.get();
        cto.setTaskList(this.taskListMapper.toEto(taskListEntity));
        List<TaskItemEntity> items = taskItemRepo.findAllWithListId(taskListEntity.getId());
        cto.setTaskItems(items.stream().map(taskItemEntity -> taskItemMapper.toEto(taskItemEntity)).toList());
        return cto;

    }
}
