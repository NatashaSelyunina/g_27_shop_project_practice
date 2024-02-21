package de.aittr.g_27_shop_project_practice.repositories.jpa;

import de.aittr.g_27_shop_project_practice.domain.jpa.JpaCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCartRepository extends JpaRepository<JpaCart, Integer> {
}