package com.salesianos.triana.dam.TrianaTourist.services;


import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.CreatedCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dto.POIDto.ConverterPOI;
import com.salesianos.triana.dam.TrianaTourist.dto.POIDto.CreatedPOIDto;
import com.salesianos.triana.dam.TrianaTourist.dto.POIDto.GetPOIDto;
import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.ListNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.SingleNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository repository;

    private final CategoryRepository categoryRepository;

    private final ConverterPOI converterPOI;

    public boolean comprobarNombre(String nombre){
        return repository.existsByName(nombre);
    }

    public String nombreCategoria (String nombre){

        return repository.nombreCategoriaPOI(nombre);
    }

    public boolean comprobarUbicacion(String ubicacion){

        return repository.existsByLocation(ubicacion);
    }


    public List<POI> POITocategoria (String nombre){

        return repository.categoriaToPOI(nombre);
    }

    public List<GetPOIDto> findAll(){
        List<POI> data = repository.findAll();

        if(data.isEmpty()){
            throw new ListNotFoundException(POI.class);
        }else {
            return data.stream()
                    .map(converterPOI::getPOIDto)
                    .collect(Collectors.toList());
        }
    }

    public POI findById (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), POI.class));
    }

    public POI save (CreatedPOIDto c){
        POI poi = POI.builder()
                .name(c.getNombre())
                .location(c.getLocation())
                .date(c.getFundacion())
                .coverPhoto(c.getCoverPhoto())
                .description(c.getDescripcion())
                .photo2(c.getPhoto2())
                .photo3(c.getPhoto3())
                .build();
        if(c.getIdCategoria() != null){
            Category cat = categoryRepository.findById(c.getIdCategoria())
                    .orElseThrow(() -> new SingleNotFoundException(c.getIdCategoria().toString(), POI.class));
            poi.setCategory(cat);
        }

        return  repository.save(poi);
    }

    public POI editar (CreatedPOIDto editado, @PathVariable Long id){
        POI result = repository.findById(id).map(e -> {
            e.setName(editado.getNombre());
            e.setDescription(editado.getDescripcion());
            e.setDate(editado.getFundacion());
            e.setLocation(editado.getLocation());
            e.setCoverPhoto(editado.getCoverPhoto());
            e.setPhoto2(editado.getPhoto2());
            e.setPhoto3(editado.getPhoto3());
            return  repository.save(e);
        }).orElseThrow(() -> new SingleNotFoundException(id.toString(), POI.class)
        );
        if(editado.getIdCategoria() != null){
            Category cat = categoryRepository.findById(editado.getIdCategoria())
                    .orElseThrow(() -> new SingleNotFoundException(editado.getIdCategoria().toString(), POI.class));
            result.setCategory(cat);
            repository.save(result);
        }

        return result;
    }

    public void  delete (@PathVariable Long id){
        POI poi = repository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), POI.class));
        repository.delete(poi);
    }


}
