package com.inditex.rrhh.icmclcwb.ws.app.trabajo.controller;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.service.TrabajoApi;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class TrabajoController implements TrabajoApi {

  @Autowired
  private TrabajoService trabajoService;

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public @Valid ResponseEntity<TrabajoDTO> create(@Valid @RequestBody final TrabajoDTO trabajo) {
    return new ResponseEntity<>(this.trabajoService.create(trabajo), HttpStatus.OK);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex,
      final WebRequest request) {
    final List<String> exceptions = new ArrayList<>();
    for (final ConstraintViolation<?> a : ex.getConstraintViolations()) {
      exceptions.add(a.getPropertyPath().toString() + ": " + a.getMessage());
    }
    return new ResponseEntity<>(exceptions, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

}
