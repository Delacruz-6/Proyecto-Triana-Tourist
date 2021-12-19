package com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class GetCategoryDto {

    private Long id;

    private String name;

    @Builder.Default
    private List<POI> puntosInteres= new ArrayList<>();
}