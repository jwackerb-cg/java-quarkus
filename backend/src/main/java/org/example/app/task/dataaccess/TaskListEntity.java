package org.example.app.task.dataaccess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.app.general.dataaccess.ApplicationPersistenceEntity;

@Entity
@Table(name = "task_list")
public class TaskListEntity extends ApplicationPersistenceEntity implements org.example.app.task.common.TaskList {

    @Column
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
