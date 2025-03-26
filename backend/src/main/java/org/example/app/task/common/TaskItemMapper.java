package org.example.app.task.common;

import org.example.app.task.dataaccess.TaskItemEntity;
import org.example.app.task.logic.TaskItemEto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TaskItemMapper {

    TaskItemEto toEto(TaskItemEntity item);

    TaskItemEntity toEntity(TaskItemEto item);
}
