package com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;

public interface RunLimpiezaService {

    void run(@NotNull @Valid final RunLimpiezaDto runLimpieza);

}
