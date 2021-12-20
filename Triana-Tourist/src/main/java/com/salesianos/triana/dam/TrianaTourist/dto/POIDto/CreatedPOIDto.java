package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;

import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.ExitCategory;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniqueNamePOI;
import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniquePhoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
@UniquePhoto (fotoPrincipal = "coverPhoto", foto2 = "photo2", foto3 = "photo3", message = "Las fotos deben ser diferentes")
public class CreatedPOIDto {

    @UniqueNamePOI( message = "{poi.name.unique}")
    @NotBlank( message = "{poi.name.notBlank}")
    private String nombre;

    @Pattern (regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", message = "{poi.location.ex}")
    private String location;

    @Lob
    private String descripcion;

    //@Past ()
    private Date fundacion;

    @ExitCategory (message = "{poi.nameCat.exitName}")
    private Long idCategoria;

    @URL(message = "{poi.coverPhoto.url}")
    @NotNull(message = "{poi.coverPhoto.notNull}")
    private String coverPhoto;
    @URL(message = "{poi.photo3.url}")
    private String photo3;
    @URL(message = "{poi.photo2.url}")
    private String photo2;

}

