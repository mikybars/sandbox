package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarPtrVentaEcommerceService {

  void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaOnlineEntregaDomicilioCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaOnlineIpodLocalizacionPersonaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlineIpodByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlinePickingByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlineEntregaTiendaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void updateActivoVentaOnlineEntregaDomicilioByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineSintLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

}
