package com.salesianos.triana.dam.TrianaTourist.validation.validators.poi;

import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniqueNamePOI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class UniqueNamePOIValidator implements ConstraintValidator<UniqueNamePOI, String> {

    @Autowired
    private final POIService servicio;

    @Override
    public void initialize(UniqueNamePOI constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && !servicio.comprobarNombre(nombre);
    }
}