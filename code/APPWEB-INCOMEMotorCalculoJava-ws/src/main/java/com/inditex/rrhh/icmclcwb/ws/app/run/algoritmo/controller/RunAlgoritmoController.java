package com.inditex.rrhh.icmclcwb.ws.app.run.algoritmo.controller;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.calcular.service.RunAlgoritmoService;
import com.inditex.rrhh.icmclcwb.dto.RunAlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.service.RunAlgoritmoApi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunAlgoritmoController implements RunAlgoritmoApi {

  @Autowired
  private RunAlgoritmoService runAlgoritmoService;

  @Override
  public @Valid ResponseEntity<RunAlgoritmoDTO> findByIdRunAlgoritmo(@PathVariable final Integer id) {
    return new ResponseEntity<>(this.runAlgoritmoService.findById(id), HttpStatus.OK);
  }

  @Override
  public @Valid ResponseEntity<List<RunAlgoritmoDTO>> findAllRunAlgoritmo() {
    return new ResponseEntity<>(this.runAlgoritmoService.findAll(), HttpStatus.OK);
  }

}
