package com.salesianos.triana.dam.TrianaTourist.repositories;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface POIRepository extends JpaRepository<POI,Long>, JpaSpecificationExecutor<POI> {

    boolean existsByName(String nombre);


    @Query(value = """
            SELECT p.name
            FROM  POI p LEFT JOIN p.CATEGORIA c
            WHERE c.id = :id
            """, nativeQuery = true)
    List<POI> findCategoryPOI(@Param("id") Long id);






}