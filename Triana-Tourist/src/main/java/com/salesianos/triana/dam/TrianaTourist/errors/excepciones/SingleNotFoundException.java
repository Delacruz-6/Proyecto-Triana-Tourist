package com.salesianos.triana.dam.TrianaTourist.errors.excepciones;

public class SingleNotFoundException extends NotFoundException{
    public SingleNotFoundException(String id, Class clazz) {
        super(String.format("No se puede encontrar una entidad del tipo %s con ID: %s", clazz.getName(), id));
    }
}
