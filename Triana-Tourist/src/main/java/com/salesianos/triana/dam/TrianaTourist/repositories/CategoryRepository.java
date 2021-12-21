package com.salesianos.triana.dam.TrianaTourist.repositories;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> , JpaSpecificationExecutor<Category> {

    boolean existsByName(String nombre);

    boolean existsById(Long id);






}