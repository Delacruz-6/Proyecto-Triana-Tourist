package com.salesianos.triana.dam.TrianaTourist.dto.RouteDto;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniquePhoto;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.route.UniquePoi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor

public class CreatedRouteDto {

    @UniqueValue (message = "{route.name.UniqueName}")
    private String name;

    /*
    @Builder.Default
    private List<String> steps= new ArrayList<>();
     */
    //No puede estar repetido
    @UniquePoi (poi="steps",message = "{route.steps.unique}")
    @Builder.Default
    private List<POI> steps= new ArrayList<>();
}
