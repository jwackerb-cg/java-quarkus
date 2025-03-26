package org.example.app.task.common;

import org.example.app.task.dataaccess.TaskListEntity;
import org.example.app.task.logic.TaskListEto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TaskListMapper {

    TaskListEto toEto(TaskListEntity list);

    TaskListEntity toEntity(TaskListEto list);
}
