package com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto;

import com.salesianos.triana.dam.TrianaTourist.models.Category;
import org.springframework.stereotype.Component;

@Component
public class ConverterCategory {

    public Category createdCategory (CreatedCategoryDto c){
        return Category.builder()
                .name(c.getNombre())
                .build();
    }

}