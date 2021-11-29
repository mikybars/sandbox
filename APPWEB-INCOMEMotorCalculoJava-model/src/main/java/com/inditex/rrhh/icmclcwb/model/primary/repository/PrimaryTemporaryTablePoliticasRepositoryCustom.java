/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
public interface PrimaryTemporaryTablePoliticasRepositoryCustom {

    // comun

    int createTempPersonas();

    int deleteTempPersonas();

    void insertTempPersonas(final TareaDto tarea, List<IdPersonaLocalDto> personas, TipoPoliticaEnum tipoPolitica);

    int createIndexTempPersonas();

    // fin comun

    // baja it

    int createTempFechasBajaIt();

    int deleteTempFechasBajaIt();

    void insertTempFechasBajaIt(final TareaDto tarea, String sistemaDestino);

    int createIndexTempFechasBajaIt();

    int createTempFechasAcumuladasBajaIt();

    int deleteTempFechasAcumuladasBajaIt();

    void insertTempFechasAcumuladasBajaIt();

    int createIndexTempFechasAcumuladasBajaIt();

    int createTempCalculoTotalizadoBajaIt();

    int deleteTempCalculoTotalizadoBajaIt();

    void insertTempCalculoTotalizadoBajaIt(final TareaDto tarea);

    int createIndexTempCalculoTotalizadoBajaIt();

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

    int createTempCalculoTotalizadoVacaciones();

    int deleteTempCalculoTotalizadoVacaciones();

    void insertTempCalculoTotalizadoVacaciones(final TareaDto tarea);

    int createIndexTempCalculoTotalizadoVacaciones();

    // fin vacaciones

    // inicio máximo garantizado (común)

    int createTempAusenciasDateMaximoGarantizado();

    int deleteTempAusenciasDateMaximoGarantizado();

    int createIndexTempAusenciasDateMaximoGarantizado();

    void insertTempAusenciasDateMaximoGarantizado();

    int createTempCalculoConAjusteMaximoGarantizado();

    int deleteTempCalculoConAjusteMaximoGarantizado();

    int createIndexTempCalculoConAjusteMaximoGarantizado();

    void insertTempCalculoConAjusteMaximoGarantizado();

    int createTempDatosMaximoGarantizado();

    int deleteTempDatosMaximoGarantizado();

    int createIndexTempDatosMaximoGarantizado();

    void insertTempDatosMaximoGarantizado();

    // fin máximo garantizado

    // inicio mínimo garantizado

    int createTempAusenciasDateMinimoGarantizado();

    int deleteTempAusenciasDateMinimoGarantizado();

    int createIndexTempAusenciasDateMinimoGarantizado();

    void insertTempAusenciasDateMinimoGarantizado(final TareaDto tarea);

    int createTempCalculoConAjusteMinimoGarantizado();

    int deleteTempCalculoConAjusteMinimoGarantizado();

    int createIndexTempCalculoConAjusteMinimoGarantizado();

    void insertTempCalculoConAjusteMinimoGarantizado();

    int createTempDatosMinimoGarantizado();

    int deleteTempDatosMinimoGarantizado();

    int createIndexTempDatosMinimoGarantizado();

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

    int createTempCalculoTotalizadoCarencia();

    int deleteTempCalculoTotalizadoCarencia();

    void insertTempCalculoTotalizadoCarencia(final TareaDto tarea);

    int createIndexTempCalculoTotalizadoCarencia();

    // fin carencia

}
