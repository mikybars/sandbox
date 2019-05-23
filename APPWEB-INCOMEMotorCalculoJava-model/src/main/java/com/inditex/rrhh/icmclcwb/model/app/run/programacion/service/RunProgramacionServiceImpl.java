package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;

@Service
@Validated
public class RunProgramacionServiceImpl implements RunProgramacionService {

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Transactional
    @Override
    public List<RunProgramacionDto> run() {
        List<RunProgramacionDto> result = new ArrayList<>();
        programacionService.findPendiente().stream().forEach(programacion -> {
            programacionService.updateEjecucion(programacion);
            RunProgramacionDto runProgramacion = RunProgramacionDto.builder().programacion(programacion)
                    .runProgramacionPeriodo(new ArrayList<>()).build();
            meta4IcmWsCalcIncomeSessionService.periodo().stream().forEach(periodo -> {
                RunProgramacionPeriodoDto runProgramacionPeriodo = RunProgramacionPeriodoDto.builder().periodo(periodo)
                        .trabajo(trabajoService.create(programacion, periodo)).build();
                runProgramacion.getRunProgramacionPeriodo().add(runProgramacionPeriodo);
            });
            result.add(runProgramacion);
        });
        return result;
    }

}