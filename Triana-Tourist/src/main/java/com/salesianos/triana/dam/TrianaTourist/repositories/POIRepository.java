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

    //Traer  el nombre de la categoria que tenga el POI
    @Query ("""
            select c.name
            from POI p LEFT JOIN p.category c
            where c.name = :nombre
            """)
    String  nombreCategoriaPOI(@Param ("nombre") String nombre);

    //Encontrar un POI por su nombre
    @Query ("""
            select p
            from POI p
            where p.name = :nombre
            """)
    Optional<POI> findPOIToNombre(@Param ("nombre") String nombre);

    boolean existsByLocation(String ubicacion);

    //Traer  los puntos de interes que contengan el nombre de la categoria pasado
    @Query ("""
            select p
            from POI p LEFT JOIN p.category c
            where c.name = :nombre
            """)
    List<POI> categoriaToPOI(@Param ("nombre") String nombre);


    //Traer  los puntos de interes de una ruta por su nombre
    @Query ("""
            select s
            from Route r LEFT JOIN r.steps s
            where s.name = :nombres
            """)
    POI  findPOIToRoute(@Param ("nombres") String nombres);

    //Traer  El POI pasandole el nombre
    @Query ("""
            select p
            from POI p
            where p.name = :nombre
            """)
    POI  findPOIToName(@Param ("nombre") String nombre);




    @Query(value = """
            SELECT * FROM POI WHERE CATEGORIA = :id
            """, nativeQuery = true)
    List<POI> findCategoryPOI(@Param("id") Long id);






}