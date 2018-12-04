package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;

public interface TrabajoRunService {

    TrabajoRunDto run(@NotNull @Valid final TrabajoRunDto trabajoRun) throws Exception;

}