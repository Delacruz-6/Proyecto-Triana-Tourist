package com.salesianos.triana.dam.TrianaTourist.repositories;

import com.salesianos.triana.dam.TrianaTourist.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {


    boolean existsByName(String nombre);

    //Comprobar si un punto de interes esta ya en una ruta
    /* PRUEBA 1
    @Query ("""
            select p.name
            from route r LEFT JOIN r.steps p
            where p.name IN
            (
            SELECT p.name
            from POI a
            WHERE p.id = a.id
            AND

            )
            """)

     */
    @Query (value = """
            select p.name
            from POI p  LEFT JOIN  ROUTE ro
            where p.name IN
            (
            SELECT p.name
            from RUTASPOI r
            WHERE (p.id = r.POI_ID) AND (p.name = :nombre)
            )
            """, nativeQuery = true)
    String comprobarPOI(@Param ("nombre") String nombre);


}
