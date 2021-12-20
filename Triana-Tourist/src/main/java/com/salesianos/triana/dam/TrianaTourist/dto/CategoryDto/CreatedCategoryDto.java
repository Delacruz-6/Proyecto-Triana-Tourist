package com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto;

import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class CreatedCategoryDto {

    @NotBlank(message = "{category.name.notBlank}")
    @UniqueValue (message = "{category.name.UniqueName}")
    private String nombre;


}
