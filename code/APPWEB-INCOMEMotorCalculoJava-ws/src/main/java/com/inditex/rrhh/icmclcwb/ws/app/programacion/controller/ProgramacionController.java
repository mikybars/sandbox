package com.inditex.rrhh.icmclcwb.ws.app.programacion.controller;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.service.ProgramacionApi;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgramacionController implements ProgramacionApi {

  @Autowired
  private ProgramacionService programacionService;

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public @Valid ResponseEntity<ProgramacionDTO> create(@Valid @RequestBody final ProgramacionDTO programacion) {
    return new ResponseEntity<>(this.programacionService.create(programacion), HttpStatus.OK);
  }

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<Void> reset() {
    this.programacionService.reset();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<Void> activa() {
    this.programacionService.activa();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<Void> activaById(@PathVariable final Long id) {
    this.programacionService.activa(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<Void> desactiva() {
    this.programacionService.desactiva();
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<Void> desactivaById(@PathVariable final Long id) {
    this.programacionService.desactiva(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
