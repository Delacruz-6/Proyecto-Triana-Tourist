package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.CreatedCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterPOI {

    private final CategoryService categoryService;
    private final POIRepository repository;

    public POI createdPOI (CreatedPOIDto c){
        POI result = POI.builder()
                .name(c.getNombre())
                .location(c.getLocation())
                .date(c.getFundacion())
                .coverPhoto(c.getCoverPhoto())
                .description(c.getDescripcion())
                .photo2(c.getPhoto2())
                .photo3(c.getPhoto3())
                .build();

        if (categoryService.findCategoriaToPoi(c.getNombreCategoria()).isPresent()){
            result.setCategory(categoryService.categoriaToNombre(c.getNombreCategoria()));
        }else{
            Category nuevaCategoria = categoryService.save(CreatedCategoryDto.builder().name(c.getNombreCategoria()).build());
            result.setCategory(nuevaCategoria);
        }
        return result;
    }

    public GetPOIDto getPOIDto (POI p){
        GetPOIDto result =  GetPOIDto.builder()
                .id(p.getId())
                .name(p.getName())
                .location(p.getLocation())
                .fundacion(p.getDate())
                .coverPhoto(p.getCoverPhoto())
                .description(p.getDescription())
                .category(repository.nombreCategoriaPOI(p.getCategory().getName()))
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();

        return result;
    }
}
