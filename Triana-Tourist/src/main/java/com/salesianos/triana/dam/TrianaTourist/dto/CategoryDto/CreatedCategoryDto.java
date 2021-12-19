package com.salesianos.triana.dam.TrianaTourist.dto.CategoryDto;

import com.salesianos.triana.dam.TrianaTourist.validation.anotations.category.UniqueValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class CreatedCategoryDto {

    @NotBlank(message = "{category.name.notBlank}")
    @UniqueValue (message = "{category.name.UniqueName}")
    private String name;


}
