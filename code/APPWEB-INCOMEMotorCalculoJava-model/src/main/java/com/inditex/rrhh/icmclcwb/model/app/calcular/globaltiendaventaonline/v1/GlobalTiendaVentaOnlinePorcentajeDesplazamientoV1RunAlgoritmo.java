package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("globalTiendaVentaOnlinePorcentajeDesplazamientoV1")
public class GlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo";
  }
}
