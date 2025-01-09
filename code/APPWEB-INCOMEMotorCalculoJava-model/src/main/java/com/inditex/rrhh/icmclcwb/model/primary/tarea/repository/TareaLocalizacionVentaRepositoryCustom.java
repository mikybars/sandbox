package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionVentaRepositoryCustom {

  List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src);

  void updateActivo(TareaDto tarea, TipoVentaConceptoEnum tipoVentaConceptoEnum, List<Integer> idsTipoDato);

  void updateActivoTrasladadas(TareaDto tarea);

  void totalizarVentasSinDevolucionLocalizacionSeccion(TareaDto tarea);

  void totalizarDevolucionLocalizacionSeccion(TareaDto tarea);

  void totalizarDevolucionLocalizacion(TareaDto tarea);

  void totalizarVentaSinDevolucionPersonasPorVenta(TareaDto tarea);

  void calcularImporteComisionVendedores(TareaDto tarea);

  void calcularImporteComisionVentaODevolucion(TareaDto tarea);

  void updateActivoNegativoTotalizado(@NonNull TareaDto tarea);

  void totalizarDevolucionesVendedor0(@NonNull TareaDto tarea);

  void repartoDevolucionVendedor0(@NonNull TareaDto tarea);

  void updateActivoManual(@NonNull TareaDto tarea);

}
