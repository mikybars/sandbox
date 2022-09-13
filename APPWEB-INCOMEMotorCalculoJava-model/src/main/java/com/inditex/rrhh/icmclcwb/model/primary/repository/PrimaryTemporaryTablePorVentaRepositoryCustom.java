package com.inditex.rrhh.icmclcwb.model.primary.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface PrimaryTemporaryTablePorVentaRepositoryCustom {

  void createTempVentaFisicaLocalizacionSeccion();

  void createIndexTempVentaFisicaLocalizacionSeccion();

  void insertTempVentaFisicaLocalizacionSeccion(TareaDto tarea);

  void deleteTempVentaFisicaLocalizacionSeccion();

  void insertTempVentaFisicaLocalizacion(TareaDto tarea);

  /**
   * Elimina la tabla temporal de fechas dentro de una estructura por venta.
   *
   * @return Some javadoc.
   */
  int deleteTempDatesEstructurasPorVenta();

  /**
   * Crea la tabla temporal de fechas dentro de una estructura por venta.
   *
   * @return Some javadoc.
   */
  int createTempDatesEstructurasPorVenta();

  /**
   * Crea un índice para la tabla temporal de fechas dentro de una estructura por venta.
   *
   * @return Some javadoc.
   */
  int indexTempDatesEstructurasPorVenta();

  /**
   * Inserta la información de fechas dentro de una estructura por venta en la tabla temporal.
   *
   * @param tarea tarea
   */
  void insertTempDatesEstructurasPorVenta(TareaDto tarea);

}
