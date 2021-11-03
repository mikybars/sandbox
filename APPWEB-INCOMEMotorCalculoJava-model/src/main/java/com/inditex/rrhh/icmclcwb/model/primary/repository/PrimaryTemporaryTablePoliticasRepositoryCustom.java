/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
public interface PrimaryTemporaryTablePoliticasRepositoryCustom {

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

}
