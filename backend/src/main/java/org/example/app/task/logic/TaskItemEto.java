package org.example.app.task.logic;

import org.example.app.general.common.AbstractEto;
import org.example.app.task.common.TaskItem;
import org.example.app.task.common.TaskList;

import java.time.LocalDateTime;


public class TaskItemEto extends AbstractEto implements TaskItem {

    private String title;
    private boolean completed;
    private boolean starred;
    private LocalDateTime deadline;
    private TaskListEto taskList;

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
        this.taskList = (TaskListEto) taskList;
    }
}
