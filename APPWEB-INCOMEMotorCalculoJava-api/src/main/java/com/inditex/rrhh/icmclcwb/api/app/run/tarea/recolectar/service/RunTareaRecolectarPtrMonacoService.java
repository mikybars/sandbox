package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaRecolectarPtrMonacoService {

  void ventaFisicaLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea);

  void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea);

  void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea);

  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(@NotNull @Valid RunTareaDto runTarea);

  void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid RunTareaDto runTarea);

  void presenciaDetallePersonaIncluidoCommerceByRunTarea(@NotNull @Valid RunTareaDto runTarea);
}
