package com.inditex.rrhh.icmclcwb.ws.app.periodo.controller;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.EstadoCalculoPeriodoService;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.service.EstadosPeriodoCalculoApi;
import com.inditex.rrhh.icmclcwb.ws.authorization.IsUser;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EstadoCalculoPeriodoController implements EstadosPeriodoCalculoApi {

  private final EstadoCalculoPeriodoService estadoCalculoPeriodoService;

  @Override
  @IsUser
  public ResponseEntity<List<EstadoPeriodoCalculoDTO>> buscarEstadosPeriodoCalculo(
      EstadoPeriodoCalculoSearchRequestDTO estadoPeriodoCalculoSearchRequestDTO) {
    return new ResponseEntity<>(
        estadoCalculoPeriodoService.buscarEstadosPeriodoCalculo(estadoPeriodoCalculoSearchRequestDTO),
        HttpStatus.OK);
  }
}
