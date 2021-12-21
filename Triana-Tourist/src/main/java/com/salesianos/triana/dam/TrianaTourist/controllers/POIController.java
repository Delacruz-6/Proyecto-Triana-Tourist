package com.salesianos.triana.dam.TrianaTourist.controllers;


import com.salesianos.triana.dam.TrianaTourist.dto.POIDto.CreatedPOIDto;
import com.salesianos.triana.dam.TrianaTourist.dto.POIDto.GetPOIDto;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.services.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {


    private final POIService servicio;


    @GetMapping ("/")
    public List<GetPOIDto> getAll(){

        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public POI getOne (@PathVariable Long id){

        return servicio.findById(id);
    }

    @PostMapping ("/")
    public POI save (@Valid @RequestBody CreatedPOIDto poiDto){

        return servicio.save(poiDto);
    }


    @PutMapping ("/{id}")
    public POI editar (@Valid  @RequestBody CreatedPOIDto categoryDto , @PathVariable Long id){
        return servicio.editar(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();

    }
}
