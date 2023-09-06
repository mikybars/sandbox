package com.inditex.rrhh.icmclcwb.ws.app.run.mantenimiento.controller;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoDTO;
import com.inditex.rrhh.icmclcwb.service.RunMantenimientoApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunMantenimientoController implements RunMantenimientoApi {

  @Autowired
  private RunMantenimientoService runMantenimientoService;

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<RunMantenimientoDTO> run() {
    return new ResponseEntity<>(this.runMantenimientoService.run(), HttpStatus.OK);
  }

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<RunMantenimientoDTO> runIdTarea(@PathVariable final Long id) {
    return new ResponseEntity<>(this.runMantenimientoService.runIdTarea(id), HttpStatus.OK);
  }

}
