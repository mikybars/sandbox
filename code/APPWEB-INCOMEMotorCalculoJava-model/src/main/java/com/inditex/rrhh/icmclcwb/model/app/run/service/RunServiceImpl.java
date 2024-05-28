package com.inditex.rrhh.icmclcwb.model.app.run.service;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunServiceImpl implements RunService {

  private static final Logger LOG = LoggerFactory.getLogger(RunServiceImpl.class);

  @Autowired
  private RunTrabajoService runTrabajoService;

  @Autowired
  private TrabajoService trabajoService;

  @Autowired
  private RunTareaService runTareaService;

  @Autowired
  private TareaService tareaService;

  @Autowired
  private RunLimpiezaService runLimpiezaService;

  @Autowired
  private RunProgramacionService runProgramacionService;

  @Override
  public void runTrabajo(@NotNull @Positive final Long id) {
    final TrabajoDTO trabajo = this.trabajoService.findByIdWithStates(id);

    if (trabajo != null) {
      this.runTrabajoService.run(RunTrabajoDto.builder().trabajo(trabajo).build());
    } else {
      RunServiceImpl.LOG.warn("El Trabajo[{}] no existe o no se encuentra en una estado válido para procesar", id);
    }
  }

  @Override
  public void runTarea(@NotNull @Positive final Long id) {
    final TareaDto tarea = this.tareaService.findByIdWithStates(id);

    if (tarea != null) {
      final TrabajoDTO trabajo = this.trabajoService.find(tarea.getIdTrabajo());
      this.runTareaService.run(RunTareaDto.builder().trabajo(trabajo).tarea(tarea).build());

    } else {
      RunServiceImpl.LOG.warn("La Tarea[{}] no existe o no se encuentra en una estado válido para procesar", id);
    }
  }

  @Override
  public void runLimpieza(@NotNull @Positive final Long id) {
    this.runLimpiezaService
        .run(RunLimpiezaDto.builder().id(id).tarea(this.tareaService.findByIdLimpieza(id)).build());
  }

  @Override
  public void runProgramacion(@NotNull @Positive final Long id) {
    this.runProgramacionService.run(id);
  }

}
