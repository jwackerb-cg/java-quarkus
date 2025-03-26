package org.example.app.task.logic;

import org.example.app.general.common.AbstractEto;
import org.example.app.task.common.TaskList;

public class TaskListEto extends AbstractEto implements TaskList {

    private String title;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
