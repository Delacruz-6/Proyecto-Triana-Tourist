package com.salesianos.triana.dam.TrianaTourist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.Lob;

@Builder
@Data
@AllArgsConstructor
public class CreatedPOIDto {

    private String nombre;

    private String location;

    @Lob
    private String descripcion;

    private Data fundacion;

    private String categoria;

    private String coverPhoto;

    private String photo3;

    private String photo2;

}
