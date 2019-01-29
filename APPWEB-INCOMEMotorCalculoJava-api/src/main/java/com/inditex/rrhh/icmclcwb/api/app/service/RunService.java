package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;

public interface RunService {

	TrabajoRunDto runTrabajo(@NotNull @Positive final Long id) throws Exception;

}