package com.salesianos.triana.dam.TrianaTourist.validation.validators.route;

import com.salesianos.triana.dam.TrianaTourist.repositories.RouteRepository;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.route.UniquePoi;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniquePoiValidator implements ConstraintValidator<UniquePoi, String> {

    //private final POIRepository poiRepository;
    //private final RouteService routeService;
    private final RouteRepository repository;

    @Override
    public void initialize(UniquePoi constraintAnnotation) { }


    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {

        return repository.comprobarPOI(nombre) == null;
    }


}