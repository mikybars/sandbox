package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

public interface TareaLocalizacionPersonaVentaRepositoryCustom {

  List<TareaLocalizacionPersonaVenta> save(List<TareaLocalizacionPersonaVenta> src);

  void totalizarDevolucionPersonaLocalizacion(TareaDto tarea);

  void totalizarVentaSinDevolucionPersonaLocalizacion(TareaDto tarea);

  void devolucionImporte0(TareaDto tarea);

  void totalizarVentaFisicaSinDevolucionPersonaSeccion(TareaDto tarea);

  void totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(TareaDto tarea);

  void totalizarDevolucionFisicaPersonaSeccion(TareaDto tarea);

  void totalizarDevolucionOnlineIpodPersonaSeccion(TareaDto tarea);
}
