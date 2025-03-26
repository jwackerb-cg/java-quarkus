package org.example.app.task.dataaccess;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

@QuarkusTest
class TaskItemRepositoryTest extends Assertions {

    @Inject
    private TaskItemRepository testee;

    @AfterEach
    void tearDown() {
    }
}