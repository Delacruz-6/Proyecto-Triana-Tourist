package com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi;

import com.salesianos.triana.dam.TrianaTourist.validation.validators.poi.PhotoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint (validatedBy = PhotoValidator.class)
@Target ({ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface  UniquePhoto  {

        String message() default "Las fotos introducidas coinciden";
        Class <?> [] groups() default {};
        Class <? extends Payload> [] payload() default {};

        String fotoPrincipal();
        String foto2();
        String foto3();

        }