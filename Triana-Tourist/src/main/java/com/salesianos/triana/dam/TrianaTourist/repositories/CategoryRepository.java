package com.salesianos.triana.dam.TrianaTourist.repositories;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> , JpaSpecificationExecutor<Category> {



    //Traer la categoria que tenga el POI con el nombre de dicha categoria
    @Query ("""
            select c
            from POI p LEFT JOIN p.category c
            where c.name = :nombre
            """)
    Optional<Category> findCategoriaPOIToNombre(@Param ("nombre") String nombre);

    Category findByNameContains(@Param("nombre") String nombre);


    boolean existsByName(String nombre);






}