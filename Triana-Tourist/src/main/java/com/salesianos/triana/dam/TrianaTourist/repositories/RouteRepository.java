package com.salesianos.triana.dam.TrianaTourist.repositories;

import com.salesianos.triana.dam.TrianaTourist.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {


}
