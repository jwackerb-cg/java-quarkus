package org.example.app.task.logic;

import java.util.List;

public class TaskListCto {
    private TaskListEto taskList;
    private List<TaskItemEto> taskItems;

    public TaskListEto getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskListEto taskList) {
        this.taskList = taskList;
    }

    public List<TaskItemEto> getTaskItems() {
        return taskItems;
    }

    public void setTaskItems(List<TaskItemEto> taskItems) {
        this.taskItems = taskItems;
    }
}
