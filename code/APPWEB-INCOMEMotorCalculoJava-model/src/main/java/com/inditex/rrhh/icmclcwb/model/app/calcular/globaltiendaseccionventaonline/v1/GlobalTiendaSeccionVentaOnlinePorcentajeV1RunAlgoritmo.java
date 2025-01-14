package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccionventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaSeccionVentaOnlinePorcentajeV1")
@RequiredArgsConstructor
public class GlobalTiendaSeccionVentaOnlinePorcentajeV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaSeccionVentaOnlinePorcentajeV1RunAlgoritmo";
  }

}
