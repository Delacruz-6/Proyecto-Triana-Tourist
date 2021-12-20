package com.salesianos.triana.dam.TrianaTourist.validation.validators.route;

import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.services.RouteService;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.route.UniqueName;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private final RouteService servicio;

    @Override
    public void initialize(UniqueName constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && !servicio.comprobarNombre(nombre);
    }
}
