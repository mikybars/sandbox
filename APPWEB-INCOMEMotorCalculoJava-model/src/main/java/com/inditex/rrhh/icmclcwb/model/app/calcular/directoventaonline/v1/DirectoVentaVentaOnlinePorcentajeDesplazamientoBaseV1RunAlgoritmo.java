package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("directoVentaVentaOnlinePorcentajeDesplazamientoBaseV1")
public class DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "DirectoVentaVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo";
  }
}
