package com.salesianos.triana.dam.TrianaTourist.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class POI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name,location, description;

    @JsonFormat (pattern="yyyy-MM-dd")
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "FK_CATEGORIA_POI"))
    private Category category;

    private String coverPhoto,photo2,photo3;


}
