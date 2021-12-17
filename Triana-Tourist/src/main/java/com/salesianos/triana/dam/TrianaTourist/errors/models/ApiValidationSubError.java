package com.salesianos.triana.dam.TrianaTourist.errors.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor  @AllArgsConstructor
public class ApiValidationSubError extends ApiSubError{

    private String objeto,mensaje;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String campo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object valorRechazado;
}
