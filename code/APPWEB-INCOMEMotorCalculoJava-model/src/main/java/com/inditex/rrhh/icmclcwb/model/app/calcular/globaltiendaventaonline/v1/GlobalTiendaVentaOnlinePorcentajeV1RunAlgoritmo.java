package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaVentaOnlinePorcentajeV1")
@RequiredArgsConstructor
public class GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaVentaOnlinePorcentajeV1RunAlgoritmo";
  }
}
