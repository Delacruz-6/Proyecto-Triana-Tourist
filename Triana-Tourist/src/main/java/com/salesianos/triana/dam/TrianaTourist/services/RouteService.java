package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.ConveterRoute;
import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.CreatedRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.GetRouteDto;
import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.ListNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.SingleNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository repository;
    private final POIRepository poiRepository;
    private final ConveterRoute conveterRoute;
/*
    public List<POI> findPOIToRutas(List<String> nombres){
        return poiRepository.findPOIToRoute(nombres);
    }

 */
    public boolean comprobarPuntoDeInteres(POI poi){
        return repository.existsBySteps(poi);
    }



    public List<GetRouteDto> findAll(){
        List<Route> data = repository.findAll();

        if(data.isEmpty()){
            throw new ListNotFoundException(Route.class);
        }else {
            return data.stream()
                    .map(conveterRoute::getRouteDto)
                    .collect(Collectors.toList());
        }
    }

    public Route findById (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), Route.class));
    }

    public Route save (CreatedRouteDto routeDto){
        return  repository.save(conveterRoute.createdRoute(routeDto));
    }

    public Route editar (CreatedRouteDto editado, @PathVariable Long id){
        return repository.findById(id).map(e -> {
            e.setName(editado.getName());
            //e.setSteps(poiRepository.findPOIToRoute(editado.getSteps()));
            e.setSteps(editado.getSteps());
            return  repository.save(e);
        }).orElseThrow(() -> new SingleNotFoundException(id.toString(), Route.class)
        );
    }

    public void  delete (@PathVariable Long id){
        Route route = repository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), Route.class));
        repository.delete(route);
    }

}
