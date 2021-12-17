package com.salesianos.triana.dam.TrianaTourist.errors;


import com.salesianos.triana.dam.TrianaTourist.errors.excepciones.NotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.models.ApiError;
import com.salesianos.triana.dam.TrianaTourist.errors.models.ApiSubError;
import com.salesianos.triana.dam.TrianaTourist.errors.models.ApiValidationSubError;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return buildApiError(HttpStatus.NOT_FOUND,ex, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ApiSubError> subErrorList = new ArrayList<>();
        ex.getAllErrors().forEach(error -> {

            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                subErrorList.add(
                        ApiValidationSubError.builder()
                                .objeto(fieldError.getObjectName())
                                .campo(fieldError.getField())
                                .valorRechazado(fieldError.getRejectedValue())
                                .mensaje(fieldError.getDefaultMessage())
                                .build()
                );
            } else {
                ObjectError objectError = error;
                subErrorList.add(
                        ApiValidationSubError.builder()
                                .objeto(objectError.getObjectName())
                                .mensaje(objectError.getDefaultMessage())
                                .build()
                );
            }
        });
        return buildApiError(status, "Errores varios en la validación",
                request, subErrorList.isEmpty() ? null : subErrorList);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiError(status,ex, request);
    }

    private ResponseEntity<Object> buildApiError(HttpStatus status, Exception ex, WebRequest request) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, ex.getMessage(), ((ServletWebRequest) request).getRequest().getRequestURI()));

    }

    private ResponseEntity<Object> buildApiError(HttpStatus status,String mensaje, WebRequest request, List<ApiSubError> subErrores) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, mensaje, ((ServletWebRequest) request).getRequest().getRequestURI(), subErrores));

    }
}
