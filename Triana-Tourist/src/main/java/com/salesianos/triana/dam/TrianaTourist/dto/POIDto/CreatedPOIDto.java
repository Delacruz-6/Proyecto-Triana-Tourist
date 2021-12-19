package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Lob;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class CreatedPOIDto {

    private String nombre;

    private String location;

    @Lob
    private String descripcion;

    private Date fundacion;

    @Builder.Default
    private String nombreCategoria = "Sin categoria";

    private String coverPhoto;

    private String photo3;

    private String photo2;

}

