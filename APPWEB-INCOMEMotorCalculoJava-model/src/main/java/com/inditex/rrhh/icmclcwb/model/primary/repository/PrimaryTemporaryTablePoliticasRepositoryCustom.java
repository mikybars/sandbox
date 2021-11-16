package com.inditex.rrhh.icmclcwb.model.primary.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface PrimaryTemporaryTablePoliticasRepositoryCustom {

  // baja it

  int createTempFechasBajaIt();

  int deleteTempFechasBajaIt();

  void insertTempFechasBajaIt(final TareaDto tarea);

  int createIndexTempFechasBajaIt();

  int createTempFechasAcumuladasBajaIt();

  int deleteTempFechasAcumuladasBajaIt();

  void insertTempFechasAcumuladasBajaIt(final TareaDto tarea);

  int createIndexTempFechasAcumuladasBajaIt();

  int createTempCalculoTotalizadoBajaIt();

  int deleteTempCalculoTotalizadoBajaIt();

  void insertTempCalculoTotalizadoBajaIt(final TareaDto tarea);

  int createIndexTempCalculoTotalizadoBajaIt();

  // fin baja it

  // antiguedad

  int createTempFechasAntiguedad();

  int deleteTempFechasAntiguedad();

  void insertTempFechasAntiguedad(final TareaDto tarea);

  int createIndexTempFechasAntiguedad();

  int createTempFechasAcumuladasAntiguedad();

  int deleteTempFechasAcumuladasAntiguedad();

  void insertTempFechasAcumuladasAntiguedad(final TareaDto tarea);

  int createIndexTempFechasAcumuladasAntiguedad();

  // fin antiguedad

  // vacaciones

  int createTempFechasVacaciones();

  int deleteTempFechasVacaciones();

  void insertTempFechasVacaciones(final TareaDto tarea);

  int createIndexTempFechasVacaciones();

  int createTempFechasAcumuladasVacaciones();

  int deleteTempFechasAcumuladasVacaciones();

  void insertTempFechasAcumuladasVacaciones(final TareaDto tarea);

  int createIndexTempFechasAcumuladasVacaciones();

  int createTempCalculoTotalizadoVacaciones();

  int deleteTempCalculoTotalizadoVacaciones();

  void insertTempCalculoTotalizadoVacaciones(final TareaDto tarea);

  int createIndexTempCalculoTotalizadoVacaciones();

  // fin vacaciones

  // inicio máximo garantizado (común)

  int createTempAusenciasDateMaximoGarantizado();

  int deleteTempAusenciasDateMaximoGarantizado();

  int createIndexTempAusenciasDateMaximoGarantizado();

  void insertTempAusenciasDateMaximoGarantizado(final TareaDto tarea);

  int createTempCalculoConAjusteMaximoGarantizado();

  int deleteTempCalculoConAjusteMaximoGarantizado();

  int createIndexTempCalculoConAjusteMaximoGarantizado();

  void insertTempCalculoConAjusteMaximoGarantizado(final TareaDto tarea);

  int createTempDatosMaximoGarantizado();

  int deleteTempDatosMaximoGarantizado();

  int createIndexTempDatosMaximoGarantizado();

  void insertTempDatosMaximoGarantizado(final TareaDto tarea);

  // fin máximo garantizado

  // inicio mínimo garantizado

  int createTempAusenciasDateMinimoGarantizado();

  int deleteTempAusenciasDateMinimoGarantizado();

  int createIndexTempAusenciasDateMinimoGarantizado();

  void insertTempAusenciasDateMinimoGarantizado(final TareaDto tarea);

  int createTempCalculoConAjusteMinimoGarantizado();

  int deleteTempCalculoConAjusteMinimoGarantizado();

  int createIndexTempCalculoConAjusteMinimoGarantizado();

  void insertTempCalculoConAjusteMinimoGarantizado(final TareaDto tarea);

  int createTempDatosMinimoGarantizado();

  int deleteTempDatosMinimoGarantizado();

  int createIndexTempDatosMinimoGarantizado();

  void insertTempDatosMininimoGarantizado(final TareaDto tarea);

  // fin mínimo garantizado

  // carencia

  int createTempFechasCarencia();

  int deleteTempFechasCarencia();

  void insertTempFechasCarencia(final TareaDto tarea);

  int createIndexTempFechasCarencia();

  int createTempFechasAcumuladasCarencia();

  int deleteTempFechasAcumuladasCarencia();

  void insertTempFechasAcumuladasCarencia(final TareaDto tarea);

  int createIndexTempFechasAcumuladasCarencia();

  int createTempCalculoTotalizadoCarencia();

  int deleteTempCalculoTotalizadoCarencia();

  void insertTempCalculoTotalizadoCarencia(final TareaDto tarea);

  int createIndexTempCalculoTotalizadoCarencia();

  // fin carencia

}
