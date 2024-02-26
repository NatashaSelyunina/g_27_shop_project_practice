package de.aittr.g_27_shop_project_practice.repositories.jpa;

import de.aittr.g_27_shop_project_practice.domain.jpa.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(
            value = "SELECT id, description, executed_at FROM task ORDER BY executed_at DESC LIMIT 5;",
            nativeQuery = true
    )
    List<Task> getLastFiveTask();
}