package com.salesianos.triana.dam.TrianaTourist.controllers;

import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.CreatedRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dto.RouteDto.GetRouteDto;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.CreatedCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.GetCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import com.salesianos.triana.dam.TrianaTourist.services.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RouteController {


    private final RouteService servicio;


    @GetMapping ("/")
    public List<GetRouteDto> getAll(){

        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public Route getOne (@PathVariable Long id){

        return servicio.findById(id);
    }

    @PostMapping ("/")
    public Route save (@Valid @RequestBody CreatedRouteDto route){

        return servicio.save(route);
    }


    @PutMapping ("/{id}")
    public Route editar (@Valid  @RequestBody CreatedRouteDto routeDto , @PathVariable Long id){
        return servicio.editar(routeDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();

    }
}
