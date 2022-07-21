package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventaonline.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeV1RepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("directoVentaVentaOnlinePorcentajeV1")
public class DirectoVentaVentaOnlinePorcentajeV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  @Autowired
  private TareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoDirectoVentaVentaOnlinePorcentajeV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "DirectoVentaVentaOnlinePorcentajeV1RunAlgoritmo";
  }
}
