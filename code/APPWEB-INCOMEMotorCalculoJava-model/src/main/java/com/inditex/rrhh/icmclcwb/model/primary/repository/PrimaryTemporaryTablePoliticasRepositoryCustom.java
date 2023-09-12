package com.inditex.rrhh.icmclcwb.model.primary.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface PrimaryTemporaryTablePoliticasRepositoryCustom {

  // comun

  int createTempPersonas();

  int deleteTempPersonas();

  void insertTempPersonas(final TareaDto tarea, List<IdPersonaLocalDto> personas, TipoPoliticaEnum tipoPolitica);

  void insertTempPersonasBajaIt(TareaDto tarea,
      List<IdPersonaLocalDto> personas,
      TipoPoliticaEnum tipoPolitica);

  int createIndexTempPersonas();

  int createTempCalculoConAjuste();

  int deleteTempCalculoConAjuste();

  void insertTempCalculoConAjuste(List<TipoPoliticaEnum> politicas);

  void insertTempCalculoConAjusteBajaIt(List<TipoPoliticaEnum> politicas);

  int createIndexTempCalculoConAjuste();

  // fin comun

  // baja it

  int createTempFechasBajaIt();

  int deleteTempFechasBajaIt();

  void insertTempFechasBajaIt(final TareaDto tarea);

  int createIndexTempFechasBajaIt();

  int createTempFechasAcumuladasBajaIt();

  int deleteTempFechasAcumuladasBajaIt();

  void insertTempFechasAcumuladasBajaIt();

  int createIndexTempFechasAcumuladasBajaIt();

  // fin baja it

  // antiguedad

  int createTempFechasAntiguedad();

  int deleteTempFechasAntiguedad();

  void insertTempFechasAntiguedad();

  int createIndexTempFechasAntiguedad();

  int createTempFechasAcumuladasAntiguedad();

  int deleteTempFechasAcumuladasAntiguedad();

  void insertTempFechasAcumuladasAntiguedad();

  int createIndexTempFechasAcumuladasAntiguedad();

  // fin antiguedad

  // vacaciones

  int createTempFechasVacaciones();

  int deleteTempFechasVacaciones();

  void insertTempFechasVacaciones();

  int createIndexTempFechasVacaciones();

  int createTempFechasAcumuladasVacaciones();

  int deleteTempFechasAcumuladasVacaciones();

  void insertTempFechasAcumuladasVacaciones();

  int createIndexTempFechasAcumuladasVacaciones();

  // fin vacaciones

  // inicio máximo / mínimo garantizado (común)

  int createTempAusenciasDateMaximoMinimoGarantizado();

  int deleteTempAusenciasDateMaximoMinimoGarantizado();

  int createIndexTempAusenciasDateMaximoMinimoGarantizado();

  void insertTempAusenciasDateMaximoMinimoGarantizado();

  int createTempDatosMaximoMinimoGarantizado();

  int deleteTempDatosMaximoMinimoGarantizado();

  int createIndexTempDatosMaximoMinimoGarantizado();

  void insertTempDatosMaximoGarantizado();

  // fin máximo / mínimo garantizado (común)

  // inicio máximo garantizado

  // fin máximo garantizado

  // inicio mínimo garantizado

  void insertTempDatosMininimoGarantizado();

  // fin mínimo garantizado

  // carencia

  int createTempFechasCarencia();

  int deleteTempFechasCarencia();

  void insertTempFechasCarencia();

  int createIndexTempFechasCarencia();

  int createTempFechasAcumuladasCarencia();

  int deleteTempFechasAcumuladasCarencia();

  void insertTempFechasAcumuladasCarencia();

  int createIndexTempFechasAcumuladasCarencia();

  void insertTempCalculoConAjusteCarencia();

  // fin carencia

}
