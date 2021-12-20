package com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi;

import com.salesianos.triana.dam.TrianaTourist.validation.validators.poi.UniqueNamePOIValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target ({ElementType.METHOD, ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy = UniqueNamePOIValidator.class)
@Documented
public @interface UniqueNamePOI {

    String message() default "El nombre del punto de ineteres ya existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
