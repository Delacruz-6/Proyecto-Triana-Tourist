package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.ConveterRoute;
import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.CreatedRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.CreatedRouteToPOI;
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
    public boolean comprobarNombre(String nombre){
        return repository.existsByName(nombre);
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

    public GetRouteDto addPoiToRoute (CreatedRouteToPOI dto, @PathVariable Long id){
        Route ruta = repository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), Route.class));

        POI creado= poiRepository.findPOIToName(dto.getNombrePOI());

        if(creado == null)
            throw new SingleNotFoundException("Nulo", POI.class);

        ruta.getSteps().add(creado);

        repository.save(ruta);
        return conveterRoute.getRouteDto(ruta);
    }

    public Route editar (CreatedRouteDto editado, @PathVariable Long id){
        return repository.findById(id).map(e -> {
            e.setName(editado.getNombre());
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

    public void deletePOIToRoute (@PathVariable Long id1, @PathVariable Long id2){
        Route route = repository.findById(id1)
                .orElseThrow(() -> new SingleNotFoundException(id1.toString(), Route.class));

        POI poi = poiRepository.findById(id2)
                .orElseThrow(() -> new SingleNotFoundException(id2.toString(), POI.class));

        route.getSteps().forEach(POI ->{
            poiRepository.findById(id2)
                    .orElseThrow(() -> new SingleNotFoundException(id2.toString(), POI.class));
        });
        route.getSteps().remove(poi);
        repository.save(route);
    }

}
