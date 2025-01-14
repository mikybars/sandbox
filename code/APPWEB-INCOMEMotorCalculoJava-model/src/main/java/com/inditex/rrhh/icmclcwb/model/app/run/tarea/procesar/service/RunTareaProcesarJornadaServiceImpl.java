package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarJornadaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionJornadaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaJornadaRepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaProcesarJornadaServiceImpl implements RunTareaProcesarJornadaService {

  private final TareaLocalizacionPersonaJornadaRepositoryCustom tareaLocalizacionPersonaJornadaRepositoryCustom;

  private final TareaLocalizacionJornadaRepositoryCustom tareaLocalizacionJornadaRepositoryCustom;

  @Override
  public void procesarJornadaLocalizacionPersona(final RunTareaDto runTarea) {
    this.tareaLocalizacionPersonaJornadaRepositoryCustom.procesar(runTarea);
  }

  @Override
  public void procesarJornadaLocalizacion(final RunTareaDto runTarea) {
    this.tareaLocalizacionJornadaRepositoryCustom.procesar(runTarea);
  }
}
