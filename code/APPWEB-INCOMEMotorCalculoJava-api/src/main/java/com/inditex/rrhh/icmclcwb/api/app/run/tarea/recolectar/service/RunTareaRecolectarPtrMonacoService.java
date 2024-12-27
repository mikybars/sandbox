package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarPtrMonacoService {

  void ventaFisicaLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea);

  void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea);

  void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea);

  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(@NonNull @Valid RunTareaDto runTarea);

  void presenciaDetalleComisionablePersonaByRunTarea(@NonNull @Valid RunTareaDto runTarea);

  void presenciaDetallePersonaIncluidoCommerceByRunTarea(@NonNull @Valid RunTareaDto runTarea);
}
