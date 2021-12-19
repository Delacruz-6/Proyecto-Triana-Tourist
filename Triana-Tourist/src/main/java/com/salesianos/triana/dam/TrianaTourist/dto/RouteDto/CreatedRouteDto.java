package com.salesianos.triana.dam.TrianaTourist.dto.RouteDto;

import com.salesianos.triana.dam.TrianaTourist.models.POI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class CreatedRouteDto {

    private String name;

    @Builder.Default
    private List<POI> steps= new ArrayList<>();
}
