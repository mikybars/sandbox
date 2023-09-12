package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("directoVentaVentaOnlinePorcentajeDesplazamientoV1")
public class DirectoVentaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "DirectoVentaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo";
  }
}
