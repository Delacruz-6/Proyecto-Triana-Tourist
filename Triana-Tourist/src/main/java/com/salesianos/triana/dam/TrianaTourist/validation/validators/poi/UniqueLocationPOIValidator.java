package com.salesianos.triana.dam.TrianaTourist.validation.validators.poi;

import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniqueLocationPOI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class UniqueLocationPOIValidator implements ConstraintValidator<UniqueLocationPOI, String> {

    @Autowired
    private final POIService servicio;

    @Override
    public void initialize(UniqueLocationPOI constraintAnnotation) { }

    @Override
    public boolean isValid(String ubicacion, ConstraintValidatorContext context) {
        return StringUtils.hasText(ubicacion) && !servicio.comprobarUbicacion(ubicacion);
    }
}