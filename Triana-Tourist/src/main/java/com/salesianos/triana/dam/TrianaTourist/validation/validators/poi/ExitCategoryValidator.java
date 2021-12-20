package com.salesianos.triana.dam.TrianaTourist.validation.validators.poi;

import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.ExitCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ExitCategoryValidator implements ConstraintValidator<ExitCategory, String> {

    @Autowired
    private final CategoryService servicio;

    @Override
    public void initialize(ExitCategory constraintAnnotation) { }

    @Override
    public boolean isValid(String nombre, ConstraintValidatorContext context) {
        return StringUtils.hasText(nombre) && servicio.comprobarNombre(nombre);
    }
}