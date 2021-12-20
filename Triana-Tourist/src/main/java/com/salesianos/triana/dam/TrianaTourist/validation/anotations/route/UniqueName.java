package com.salesianos.triana.dam.TrianaTourist.validation.anotations.route;

import com.salesianos.triana.dam.TrianaTourist.validation.validators.category.UniqueValidator;
import com.salesianos.triana.dam.TrianaTourist.validation.validators.route.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target ({ElementType.METHOD, ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = UniqueNameValidator.class)
@Documented
public @interface UniqueName {
    String message() default "El nombre de la ruta ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
