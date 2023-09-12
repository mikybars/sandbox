package com.inditex.rrhh.icmclcwb.ws.app.run.programacion.controller;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.dto.RunProgramacionDTO;
import com.inditex.rrhh.icmclcwb.service.RunProgramacionApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunProgramacionController implements RunProgramacionApi {

  @Autowired
  private RunProgramacionService runProgramacionService;

  @Override
  @PreAuthorize("hasAuthority('admin')")
  public ResponseEntity<List<RunProgramacionDTO>> create() {
    return new ResponseEntity<>(this.runProgramacionService.create(), HttpStatus.OK);
  }

}
