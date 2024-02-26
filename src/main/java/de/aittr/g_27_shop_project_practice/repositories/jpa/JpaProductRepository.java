package de.aittr.g_27_shop_project_practice.repositories.jpa;

import de.aittr.g_27_shop_project_practice.domain.jpa.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Integer> {
    void deleteByName(String name);
    boolean existsByName(String name);
    @Query(value = "select name from product order by id desc limit 1;", nativeQuery = true)
    String getNameLastProduct();
}