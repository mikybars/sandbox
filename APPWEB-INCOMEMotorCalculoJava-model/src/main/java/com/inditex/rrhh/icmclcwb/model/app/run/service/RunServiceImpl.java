package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.service.RunProcesoService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private RunProcesoService runProcesoService;

    @Autowired
    private ProcesoService procesoService;

    @Override
    public RunProcesoDto runProceso(@NotNull @Positive final Long id) {
        return runProcesoService.run(RunProcesoDto.builder().proceso(procesoService.findProceso(id)).build());
    }

}
