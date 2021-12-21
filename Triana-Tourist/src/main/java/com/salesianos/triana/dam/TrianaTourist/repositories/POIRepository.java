package com.salesianos.triana.dam.TrianaTourist.repositories;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POIRepository extends JpaRepository<POI,Long>, JpaSpecificationExecutor<POI> {

    boolean existsByName(String nombre);


    @Query(value = """
             SELECT p.name
             FROM  POI p
             WHERE p.CATEGORIA =:id
            """, nativeQuery = true)
    List<String> findCategoryPOIName(@Param("id") Long id);

    @Query(value = """
             SELECT p.*
             FROM  POI p
             WHERE p.CATEGORIA =:id
            """, nativeQuery = true)
    List<POI> findCategoryPOI(@Param("id") Long id);






}