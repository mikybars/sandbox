package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendapersonasporventanovendedores.v1;

import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoBaseRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("globalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1")
@RequiredArgsConstructor
public class GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo extends AbstractV1RunAlgoritmo
    implements RunAlgoritmo {

  private final TareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom;

  @Override
  protected TareaCalculoAlgoritmoBaseRepositoryCustom getTareaCalculoAlgoritmoRespositoryCustom() {
    return this.tareaCalculoAlgoritmoGlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RepositoryCustom;
  }

  @Override
  protected String getAlgoritmoName() {
    return "GlobalTiendaPersonasPorVentaNoVendedoresPorcentajeDesplazamientoV1RunAlgoritmo";
  }
}
