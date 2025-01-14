package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendapersonasporventanovendedores.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1")
@RequiredArgsConstructor
public class GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RunAlgoritmo extends AbstractV1RunAlgoritmo
    implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoBaseV1";
  }
}
