package com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi;

import com.salesianos.triana.dam.TrianaTourist.validation.validators.category.UniqueValidator;
import com.salesianos.triana.dam.TrianaTourist.validation.validators.poi.ExitCategoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target ({ElementType.METHOD, ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = ExitCategoryValidator.class)
@Documented
public @interface ExitCategory {

    String message() default "El nombre de la categoria no existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
