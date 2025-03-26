package org.example.app.task.dataaccess;

import jakarta.persistence.*;
import org.example.app.general.dataaccess.ApplicationPersistenceEntity;
import org.example.app.task.common.TaskItem;
import org.example.app.task.common.TaskList;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_item")
public class TaskItemEntity extends ApplicationPersistenceEntity implements TaskItem {

    @Column
    private String title;

    @Column
    private boolean completed;

    @Column
    private boolean starred;

    @Column
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private TaskListEntity taskList;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean isStarred() {
        return starred;
    }

    @Override
    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    @Override
    public LocalDateTime getDeadline() {
        return deadline;
    }

    @Override
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public TaskList getTaskList() {
        return taskList;
    }

    @Override
    public void setTaskList(TaskList taskList) {
        this.taskList = (TaskListEntity) taskList;
    }


}
