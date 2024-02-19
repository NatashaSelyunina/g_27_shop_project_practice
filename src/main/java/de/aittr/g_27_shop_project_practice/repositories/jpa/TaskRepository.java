package de.aittr.g_27_shop_project_practice.repositories.jpa;

import de.aittr.g_27_shop_project_practice.domain.jpa.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}