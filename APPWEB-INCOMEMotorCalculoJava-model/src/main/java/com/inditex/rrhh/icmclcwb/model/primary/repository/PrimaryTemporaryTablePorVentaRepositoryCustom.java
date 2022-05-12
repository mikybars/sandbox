package com.inditex.rrhh.icmclcwb.model.primary.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface PrimaryTemporaryTablePorVentaRepositoryCustom {

  void createTempVentaFisicaLocalizacionSeccion();

  void createIndexTempVentaFisicaLocalizacionSeccion();

  void insertTempVentaFisicaLocalizacionSeccion(TareaDto tarea);

  void deleteTempVentaFisicaLocalizacionSeccion();

  void insertTempVentaFisicaLocalizacion(TareaDto tarea);

}
