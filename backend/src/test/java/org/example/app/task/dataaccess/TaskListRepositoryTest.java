package org.example.app.task.dataaccess;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@QuarkusTest
public class TaskListRepositoryTest extends Assertions {

    @Inject
    private TaskListRepository testee;

    @Inject
    private SessionFactory sessionFactory;

    private Session session;

    @BeforeEach
    public void setup() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void testFindById() {
        //given
        var listId = 1L;

        //when
        Optional<TaskListEntity> list = testee.findById(listId);

        //then
        assertThat(list).isPresent();
        assertThat(list.get().getTitle()).isEqualTo("Shopping List");
    }

    @Test
    public void testFindAllTaskListsWithItemsThatAreDueInNextWeek() {
        //given
        TaskListEntity testList1 = testee.findById(1L).orElse(null);
        TaskListEntity testList2 = testee.findById(2L).orElse(null);

        TaskItemEntity testItem1 = new TaskItemEntity();
        testItem1.setTitle("Test1");
        testItem1.setDeadline(LocalDateTime.now().plusDays(3));
        testItem1.setTaskList(testList1);

        TaskItemEntity testItem2 = new TaskItemEntity();
        testItem2.setTitle("Test2");
        testItem2.setDeadline(LocalDateTime.now().plusDays(12));
        testItem2.setTaskList(testList2);

        session.persist(testItem1);
        session.persist(testItem2);
        session.flush();

        LocalDateTime dueDate = LocalDateTime.now().plusWeeks(1);
        //when
        List<TaskListEntity> taskLists = testee.findAllWithDueItems(dueDate);

        //then
        assertThat(taskLists).hasSize(2);
        assertThat(taskLists.getFirst().getId()).isEqualTo(4L); //tasklist 4 has two items with due time in past
        assertThat(taskLists.get(1).getId()).isEqualTo(1L);
    }

    @Test
    public void testFindAllTasksListsWithItemsThatAreOverdue() {
        //given
        LocalDateTime dueDate = LocalDateTime.now();
        //when
        List<TaskListEntity> taskLists = testee.findAllWithDueItems(dueDate);
        //then
        assertThat(taskLists).hasSize(1);
        assertThat(taskLists.getFirst().getId()).isEqualTo(4L);
    }
}
