package com.salesianos.triana.dam.TrianaTourist.repositories;

import com.salesianos.triana.dam.TrianaTourist.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {


    boolean existsByName(String nombre);

    @Query (value = """
            select p.id
            from POI p  LEFT JOIN  ROUTE ro
            where p.name IN
            (
            SELECT p.name
            from RUTASPOI r
            WHERE (p.id = r.POI_ID) AND (p.id = :id)
            )
            """, nativeQuery = true)
    Long comprobarPOI(@Param ("id") Long id);


}
