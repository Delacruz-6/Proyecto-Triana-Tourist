package com.salesianos.triana.dam.TrianaTourist.repositories;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface POIRepository extends JpaRepository<POI,Long>, JpaSpecificationExecutor<POI> {

    //Traer  el nombre de la categoria que tenga el POI
    @Query ("""
            select c.name
            from POI p LEFT JOIN p.category c
            where c.name = :nombre
            """)
    String  nombreCategoriaPOI(@Param ("nombre") String nombre);

    boolean existsByLocation(String ubicacion);

    //Traer  los puntos de interes que contengan el nombre de la categoria pasado
    @Query ("""
            select p
            from POI p LEFT JOIN p.category c
            where c.name = :nombre
            """)
    List<POI> categoriaToPOI(@Param ("nombre") String nombre);

/*
    //Traer  los puntos de interes de una ruta por su nombre
    @Query ("""
            select s
            from Route r LEFT JOIN r.steps s
            where s.name = :nombres
            """)
    List<POI>  findPOIToRoute(@Param ("nombres") List<String> nombres);

 */


}