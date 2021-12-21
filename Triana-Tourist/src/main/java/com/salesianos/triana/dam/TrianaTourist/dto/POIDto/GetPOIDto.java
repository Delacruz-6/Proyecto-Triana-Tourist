package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Calendar;

@Builder
@Data
@AllArgsConstructor
public class GetPOIDto {

    private Long id;

    private String name,location, description;

    private LocalDate fundacion;

    private Long category;

    private String coverPhoto;

    private String photo2, photo3;
}

