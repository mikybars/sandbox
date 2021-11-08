/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
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

    // inicio máximo / mínimo garantizado (común)

    int createTempAusenciasDateMaxMinGarantizado();

    int deleteTempAusenciasDateMaxMinGarantizado();

    int createIndexTempAusenciasDateMaxGarantizado();

    int createIndexTempAusenciasDateMinGarantizado();

    void insertTempAusenciasDateMaxMinGarantizado(final TareaDto tarea);

    int createTempCalculoConAjusteMaxMinGarantizado();

    int deleteTempCalculoConAjusteMaxMinGarantizado();

    int createIndexTempCalculoConAjusteMaxMinGarantizado();

    void insertTempCalculoConAjusteMaxMinGarantizado(final TareaDto tarea);

    int createTempDatosMaxMinGarantizado();

    int deleteTempDatosMaxMinGarantizado();

    int createIndexTempDatosMaxMinGarantizado();

    // fin máximo / mínimo garantizado (común)

    // inicio máximo garantizado

    void insertTempDatosMaxGarantizado(final TareaDto tarea);

    // fin máximo garantizado

    // inicio mínimo garantizado

    void insertTempDatosMinGarantizado(final TareaDto tarea);

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
