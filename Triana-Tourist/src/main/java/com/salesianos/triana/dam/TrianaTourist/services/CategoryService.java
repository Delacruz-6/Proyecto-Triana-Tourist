package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.GetCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.ConverterCategory;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.CreatedCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.ListNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.SingleNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.repositories.CategoryRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository catRepository;
    private final POIRepository poiRespository;
    private final ConverterCategory converterCategory;

    public boolean comprobarId(Long id){
        return catRepository.existsById(id);
    }
    public boolean comprobarNombre(String name){
        return catRepository.existsByName(name);
    }



    public List<POI> POITocategoria (String nombre){
        comprobarCategoria(nombre);
        return poiRespository.categoriaToPOI(nombre);
    }

    public Category categoriaToNombre (String nombre){
        return catRepository.findByNameContains(nombre);
    }

    public Optional<Category> findCategoriaToPoi (String nombre){
        comprobarCategoria(nombre);
        return catRepository.findCategoriaPOIToNombre(nombre);
    }

    public List<GetCategoryDto> findAll(){
        List<Category> data = catRepository.findAll();

        if(data.isEmpty()){
            throw new ListNotFoundException(Category.class);
        }else {
            return data.stream()
                    .map(converterCategory::getCategoryDto)
                    .collect(Collectors.toList());
        }
    }

    public Category findById (Long id){
        return catRepository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), Category.class));
    }

    public Category save (CreatedCategoryDto categoryDto){
        return  catRepository.save(converterCategory.createdCategory(categoryDto));
    }

    public Category editar (CreatedCategoryDto editado, @PathVariable Long id){
        return catRepository.findById(id).map(e -> {
            e.setName(editado.getNombre());
            return  catRepository.save(e);
        }).orElseThrow(() -> new SingleNotFoundException(id.toString(), Category.class)
        );
    }

    public void  delete (@PathVariable Long id){
        Category categoria = catRepository.findById(id)
                .orElseThrow(() -> new SingleNotFoundException(id.toString(), Category.class));
        List<POI> puntoDeinteres = poiRespository.findCategoryPOI(id);

        puntoDeinteres.forEach( p ->{
            p.setCategory(null);
            poiRespository.save(p);
        });
        catRepository.delete(categoria);
    }


    public void comprobarCategoria (String nombre){
        Optional <Category> category= catRepository.findCategoriaPOIToNombre(nombre);
        category.orElseThrow(() -> new SingleNotFoundException("Nulo", Category.class));
    }








}