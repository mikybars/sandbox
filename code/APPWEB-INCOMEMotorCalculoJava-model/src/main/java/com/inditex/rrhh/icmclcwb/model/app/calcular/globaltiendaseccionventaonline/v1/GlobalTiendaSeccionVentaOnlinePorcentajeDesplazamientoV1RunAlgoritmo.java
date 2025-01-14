package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccionventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1")
@RequiredArgsConstructor
public class GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo";
  }
}
