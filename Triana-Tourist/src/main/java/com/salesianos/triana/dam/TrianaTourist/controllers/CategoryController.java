package com.salesianos.triana.dam.TrianaTourist.controllers;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.CreatedCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto.GetCategoryDto;
import com.salesianos.triana.dam.TrianaTourist.models.Category;
import com.salesianos.triana.dam.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoryController {

    private final CategoryService servicio;


    @GetMapping("/")
    public List<GetCategoryDto> getAll(){

        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public Category getOne (@PathVariable Long id){

        return servicio.findById(id);
    }

    @PostMapping("/")
    public Category save (@Valid @RequestBody CreatedCategoryDto categoria){

        return servicio.save(categoria);
    }


    @PutMapping("/{id}")
    public Category editar (@Valid  @RequestBody CreatedCategoryDto categoryDto , @PathVariable Long id){
        return servicio.editar(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();

    }
}
