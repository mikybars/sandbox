package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccionventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1")
@RequiredArgsConstructor
public class GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo extends AbstractV1RunAlgoritmo
    implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo";
  }
}
