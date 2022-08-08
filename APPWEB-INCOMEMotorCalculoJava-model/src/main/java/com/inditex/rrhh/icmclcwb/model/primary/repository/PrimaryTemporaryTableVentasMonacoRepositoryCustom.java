package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

public interface PrimaryTemporaryTableVentasMonacoRepositoryCustom {

  /**
   * Elimina la tabla temporal de ventas diarias de Monaco.
   *
   * @return Some javadoc.
   */
  int deleteTempMonacoPtr();

  /**
   * Crea la tabla temporal de ventas diarias de Monaco.
   *
   * @return Some javadoc.
   */
  int createTempMonacoPtr();

  /**
   * Inserta en la tabla temporal de ventas diarias de Monaco.
   *
   * @return Some javadoc.
   */
  List<TareaLocalizacionVenta> insertTempMonacoPtr(final List<TareaLocalizacionVenta> src);

  /**
   * Mergea la tabla temporal con la tabla destino.
   *
   */
  void mergeIntoTareaLocalizacionVenta(final TareaDto tarea);

}
