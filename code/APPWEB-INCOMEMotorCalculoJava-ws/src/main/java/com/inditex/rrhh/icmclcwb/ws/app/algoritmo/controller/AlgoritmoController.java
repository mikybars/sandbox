package com.inditex.rrhh.icmclcwb.ws.app.algoritmo.controller;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.service.AlgoritmoApi;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlgoritmoController implements AlgoritmoApi {

  @Autowired
  private AlgoritmoService algoritmoService;

  @Override
  public @Valid ResponseEntity<List<AlgoritmoDTO>> findAll() {
    return new ResponseEntity<>(this.algoritmoService.findAll(), HttpStatus.OK);
  }

  @Override
  public @Valid ResponseEntity<Boolean> checkDuplicatedActives() {
    return new ResponseEntity<>(this.algoritmoService.checkDuplicatedActives(), HttpStatus.OK);
  }

  @Override
  public @Valid ResponseEntity<AlgoritmoDTO> findById(@PathVariable final Integer id) {
    return new ResponseEntity<>(this.algoritmoService.findById(id), HttpStatus.OK);
  }

}
