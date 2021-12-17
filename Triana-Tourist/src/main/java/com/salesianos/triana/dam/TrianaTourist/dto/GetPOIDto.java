package com.salesianos.triana.dam.TrianaTourist.dto;


import com.salesianos.triana.dam.TrianaTourist.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class GetPOIDto {

    private Long id;
    
    private String name,location, description;

    private Date date;

    private String category;

    private String coverPhoto;
}
