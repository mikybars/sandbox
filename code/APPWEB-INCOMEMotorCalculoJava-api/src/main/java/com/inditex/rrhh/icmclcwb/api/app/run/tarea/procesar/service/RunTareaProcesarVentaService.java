package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;

public interface RunTareaProcesarVentaService {

  void saveAbierto(@Valid RunTareaDto runTarea);

  void saveCerrado(@Valid RunTareaDto runTarea);

  void trasladar(@Valid RunTareaDto runTarea);

  void compensar(@Valid RunTareaDto runTarea);

  void repartoVentaEntregaDomicilioPorVentasAgrupaciones(@Valid RunTareaDto runTarea);

  void repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(@Valid RunTareaDto runTarea);

  void repartoVentaEntregaDomicilioSeccion(@Valid RunTareaDto runTarea);

  void updateActivoTrasladadas(@Valid RunTareaDto runTarea);

  void saveAbiertoSeccion(@Valid RunTareaDto runTarea);

  void saveCerradoSeccion(@Valid RunTareaDto runTarea);

  void compensarOnlineSeccionCerrada(@Valid RunTareaDto runTarea);

  void updateActivoTrasladadasSeccion(@Valid RunTareaDto runTarea);

  void agruparOnlineSeccionDia(@Valid RunTareaDto runTarea);

  void updateActivoTrasladadasTotalizado(@Valid RunTareaDto runTarea);

  void updateImporteEstructuraPoliticas(@Valid RunTareaDto runTarea);

  void totalizarDevolucionLocalizacionSeccion(@Valid RunTareaDto runTarea);

  void totalizarDevolucionLocalizacion(@Valid RunTareaDto runTarea);

  void totalizarVentasSinDevolucionLocalizacionSeccion(@Valid RunTareaDto runTarea);

  void totalizarVentaSinDevolucionPersonasPorVenta(@Valid RunTareaDto tarea);

  void totalizarVentaSinDevolucionPersonaLocalizacion(@Valid RunTareaDto tarea);

  void totalizarDevolucionPersonaLocalizacion(@Valid RunTareaDto tarea);

  void calcularImporteComisionVendedores(@Valid RunTareaDto tarea);

  void calcularImporteComisionVentaODevolucion(@Valid RunTareaDto tarea);

  void updateActivoNegativoTotalizado(@Valid RunTareaDto tarea);

  void updateActivoExcepcionada(@Valid RunTareaDto runTarea);

  void updateActivoCongelada(@Valid RunTareaDto runTarea);

  void totalizarPresupuesto(@Valid RunTareaDto runTarea);

  void totalizarDevolucionesVendedor0(@Valid RunTareaDto tarea);

  void repartoDevolucionVendedor0(@Valid RunTareaDto tarea);

  void updateActivoCongeladaSeccion(@Valid RunTareaDto runTarea);

  void updateActivoManual(@Valid RunTareaDto tarea);

  void devolucionImporte0(@Valid RunTareaDto tarea);

  void totalizarVentaFisicaSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea);

  void totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(@Valid RunTareaDto tarea);

  void totalizarDevolucionFisicaPersonaSeccion(@Valid RunTareaDto tarea);

  void totalizarDevolucionOnlineIpodPersonaSeccion(@Valid RunTareaDto tarea);

}
