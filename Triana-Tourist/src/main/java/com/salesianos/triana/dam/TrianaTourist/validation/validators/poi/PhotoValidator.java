package com.salesianos.triana.dam.TrianaTourist.validation.validators.poi;

import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniquePhoto;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhotoValidator implements ConstraintValidator<UniquePhoto, Object> {

    private String fotoPrincipal;
    private String foto2;
    private String foto3;

    @Override
    public void initialize(UniquePhoto constraintAnnotation) {
        fotoPrincipal = constraintAnnotation.fotoPrincipal();
        foto2 = constraintAnnotation.foto2();
        foto3 = constraintAnnotation.foto3();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String foto1 = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(fotoPrincipal);
        String foto2v = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(foto2);
        String foto3v = (String) PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(foto3);

        if (!foto2v.isEmpty()){
            return StringUtils.hasText(foto1) &&  !foto1.contentEquals(foto2v);
        }else if(!foto3v.isEmpty()){
            return StringUtils.hasText(foto1) && !foto1.contentEquals(foto3v) ;
        }
        return StringUtils.hasText(foto1);
    }
}