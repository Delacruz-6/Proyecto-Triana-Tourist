package com.salesianos.triana.dam.TrianaTourist.dto.POIDto;

import com.salesianos.triana.dam.TrianaTourist.validation.anotations.poi.UniquePhoto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@UniquePhoto (fotoPrincipal = "coverPhoto", foto2 = "photo2", foto3 = "photo3", message = "{poi.photos.unique}")
public class CreatedPOIDto {

    @NotBlank( message = "{poi.name.notBlank}")
    private String nombre;

    @Pattern (regexp = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$", message = "{poi.location.ex}")
    private String location;

    @Lob
    private String descripcion;

    //@Past ()
    private Date fundacion;

    //Categoria debe ser existente
    @Builder.Default
    private String nombreCategoria = "Sin categoria";

    @URL(message = "{poi.coverPhoto.url}")
    @NotNull(message = "{poi.coverPhoto.notNull}")
    private String coverPhoto;
    @URL(message = "{poi.photo3.url}")
    private String photo3;
    @URL(message = "{poi.photo2.url}")
    private String photo2;

}

