package com.salesianos.triana.dam.TrianaTourist.validation.anotations.route;

import com.salesianos.triana.dam.TrianaTourist.validation.validators.category.UniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target ({ElementType.METHOD, ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = UniqueValidator.class)
@Documented
public @interface UniquePoi {
    String message() default "El nombre de la categoria ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}