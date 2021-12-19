package com.salesianos.triana.dam.TrianaTourist.validation.validators.category;

import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {


    private final CategoryService servicio;

    @Override
    public void initialize(UniqueValue constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && !servicio.comprobarNombre(nombre);
    }
}