package com.inditex.rrhh.icmclcwb.api.app.service;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;

public interface TrabajoRunConsolidarService {

	TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception;

}