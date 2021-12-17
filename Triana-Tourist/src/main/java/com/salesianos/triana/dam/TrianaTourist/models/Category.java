package com.salesianos.triana.dam.TrianaTourist.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


}
