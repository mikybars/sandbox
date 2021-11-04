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

}
