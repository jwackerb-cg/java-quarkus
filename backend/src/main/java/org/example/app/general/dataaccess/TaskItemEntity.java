package org.example.app.general.dataaccess;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task_item")
public class TaskItemEntity extends ApplicationPersistenceEntity {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public TaskListEntity getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskListEntity taskList) {
        this.taskList = taskList;
    }
}
