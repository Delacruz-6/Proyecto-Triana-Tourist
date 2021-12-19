package com.salesianos.triana.dam.TrianaTourist.validation.validators.route;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import com.salesianos.triana.dam.TrianaTourist.services.RouteService;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.route.UniquePoi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@RequiredArgsConstructor
public class UniquePoiValidator implements ConstraintValidator<UniquePoi, Object> {

    private String poi;

    private final POIRepository poiRepository;
    private final RouteService routeService;

    @Override
    public void initialize(UniquePoi constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        POI puntoInteres = (POI) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(poi);
        List<POI> listadoPOI =poiRepository.findAll();
        return !listadoPOI.equals(routeService.comprobarPuntoDeInteres(puntoInteres));
    }


}