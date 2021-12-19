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
    //private final CategoryService categoryService;

    private final ConverterPOI converterPOI;

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

    public POI save (CreatedPOIDto poiDto){
        return  repository.save(converterPOI.createdPOI(poiDto));
    }

    public POI editar (CreatedPOIDto editado, @PathVariable Long id){
        Category categoria;
        if (categoryRepository.findCategoriaPOIToNombre(editado.getNombreCategoria()).isPresent()){
            categoria= categoryRepository.findByNameContains(editado.getNombreCategoria());
        }else{
            //categoria = categoryRepository.save(CreatedCategoryDto.builder().name(editado.getNombreCategoria()).build());
        }
        return repository.findById(id).map(e -> {
            e.setName(editado.getNombre());
            e.setDescription(editado.getDescripcion());
            //e.setCategory(categoria);
            e.setDate(editado.getFundacion());
            e.setLocation(editado.getLocation());
            e.setCoverPhoto(editado.getCoverPhoto());
            e.setPhoto2(editado.getPhoto2());
            e.setPhoto3(editado.getPhoto3());
            return  repository.save(e);
        }).orElseThrow(() -> new SingleNotFoundException(id.toString(), POI.class)
        );
    }

    public void  delete (@PathVariable Long id){
        POI poi = repository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), POI.class));
        repository.delete(poi);
    }


}
