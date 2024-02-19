package de.aittr.g_27_shop_project_practice.repositories.jpa;

import de.aittr.g_27_shop_project_practice.domain.jpa.JpaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer, Integer> {
}