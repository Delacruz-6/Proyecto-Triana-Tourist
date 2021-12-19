package com.salesianos.triana.dam.TrianaTourist.dto.RouteDto;

import com.salesianos.triana.dam.TrianaTourist.dto.POIDto.ConverterPOI;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConveterRoute {

    private final POIRepository poiRepository;
    private final POIService poiService;
    private final ConverterPOI converterPOI;

    public Route createdRoute (CreatedRouteDto c){

        Route result = Route.builder()
                .name(c.getName())
                .steps(c.getSteps())
                .build();
        /*
        result.setSteps(poiRepository.findPOIToRoute(c.getSteps().stream().map(poi -> {
            poi.
        }).collect(Collectors.toList())));

        if(poiRepository.findPOIToNombre(c.getSteps()).isPresent()){
            result.setSteps(poiRepository.findPOIToRoute(c.getSteps()));
        }
        result.for

        List<POI> listaPoi = poiRepository.findAll();
        listaPoi.forEach( );

         */
        return result;
    }

    public GetRouteDto getRouteDto (Route r){
        return GetRouteDto.builder()
                .id(r.getId())
                .name(r.getName())
                .steps(r.getSteps())
                .build();
    }


}