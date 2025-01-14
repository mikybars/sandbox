package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendapersonasporventanovendedores.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaPersonasPorVentaNoVendedoresPorcentajeV1")
@RequiredArgsConstructor
public class GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeV1RunAlgoritmo extends AbstractV1RunAlgoritmo implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeV1RunAlgoritmo";
  }

}
