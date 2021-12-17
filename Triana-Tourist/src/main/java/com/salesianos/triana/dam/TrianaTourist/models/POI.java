package com.salesianos.triana.dam.TrianaTourist.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class POI {

    @Id
    @GeneratedValue
    private Long id;

    private String name,location, description;

    private Date date;


    @ManyToOne
    @JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "FK_CATEGORIA_POI"))
    private Category category;

    private String coverPhoto,photo2,photo3;

}
