package com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterCategory {

    private final CategoryRepository categoryRepository;
    //private final POIService poiService;
    private final POIRepository poiRepository;

    public Category createdCategory (CreatedCategoryDto c){
        return Category.builder()
                .name(c.getNombre())
                .build();

    }

    public GetCategoryDto getCategoryDto (Category c){
        return GetCategoryDto.builder()
                .id(c.getId())
                .name(c.getName())
                //.puntosInteres(categoryRepository.findCategoriaPOIToNombre(c.getName()))
                .build();
    }

}