package com.salesianos.triana.dam.TrianaTourist.dto.RouteDto;

import com.salesianos.triana.dam.TrianaTourist.validation.anotations.route.UniquePoi;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedRouteToPOI {

    @UniquePoi ( message = "{route.steps.unique}")
    @NotBlank ( message = "{poi.name.notBlank}")
    private String nombrePOI;
}
