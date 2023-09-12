package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaRecolectarPtrVentaEcommerceService {

  void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaOnlineEntregaDomicilioCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaOnlineIpodLocalizacionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlineIpodByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlinePickingByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlineEntregaTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlineEntregaDomicilioByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineSintLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
