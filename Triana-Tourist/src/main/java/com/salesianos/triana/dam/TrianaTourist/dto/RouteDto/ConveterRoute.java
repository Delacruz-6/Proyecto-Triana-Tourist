package com.salesianos.triana.dam.TrianaTourist.dto.RouteDto;

import com.salesianos.triana.dam.TrianaTourist.models.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConveterRoute {

    public Route createdRoute (CreatedRouteDto c){

        return Route.builder()
                .name(c.getName())
                .steps(c.getSteps())
                .build();
    }

    public GetRouteDto getRouteDto (Route r){
        return GetRouteDto.builder()
                .id(r.getId())
                .name(r.getName())
                .steps(r.getSteps())
                .build();
    }


}