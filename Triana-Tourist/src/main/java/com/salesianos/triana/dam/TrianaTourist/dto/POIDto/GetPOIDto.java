package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class GetPOIDto {

    private Long id;

    private String name,location, description;

    private Date fundacion;

    private Long category;

    private String coverPhoto;

    private String photo2, photo3;
}

