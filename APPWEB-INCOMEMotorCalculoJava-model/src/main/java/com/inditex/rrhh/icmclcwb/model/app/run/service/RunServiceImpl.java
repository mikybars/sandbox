package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private RunTrabajoService trabajoRunService;

    @Autowired
    private TrabajoService trabajoService;

    @Override
    public RunTrabajoDto runTrabajo(@NotNull @Positive final Long id) {
        return trabajoRunService.run(RunTrabajoDto.builder().trabajoDto(trabajoService.findTrabajo(id)).build());
    }

}
