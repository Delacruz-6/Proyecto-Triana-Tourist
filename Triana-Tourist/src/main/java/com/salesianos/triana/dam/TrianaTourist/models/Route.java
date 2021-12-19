package com.salesianos.triana.dam.TrianaTourist.models;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Route {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @Builder.Default
    @JoinTable(joinColumns = @JoinColumn(name = "poi_id",
            foreignKey = @ForeignKey(name="FK_ROUTE_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name="FK_POI_ROUTE")),
            name = "rutasPOI"
    )
    private List<POI> steps= new ArrayList<>();


    public List<String> showToPOIToRoute(){
        return steps.stream().map(POI::getName).collect(Collectors.toList());
    }
/*
    public List<String> addToPOIToRoute(List <String> nombres){
        return steps.stream().map(showToPOIToRoute().forEach(poi -> poi.add)
        }).collect(Collectors.toList());
    }
 */



}
