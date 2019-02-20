package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.programacion.repository.ProgramacionRepository;

@Service
@Validated
public class RunProgramacionServiceImpl implements RunProgramacionService {

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private ProgramacionRepository programacionRepository;

    @Autowired
    private ProgramacionMapper programacionMapper;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Override
    public List<RunProgramacionDto> run() {
        List<RunProgramacionDto> result = new ArrayList<>();
        programacionMapper
                .programacionToProgramacionDto(
                        programacionRepository.findByFechaSiguienteEjecucionBeforeAndActivaTrue(new Date()))
                .stream().forEach(programacion -> {
                    RunProgramacionDto runProgramacion = RunProgramacionDto.builder().programacion(programacion)
                            .runProgramacionPeriodo(new ArrayList<>()).build();
                    programacion.setFechaUltimaEjecucion(LocalDateTime.now());
                    // TODO No marcamos la siguiente ejecucion para que siempre se ejecute
                    // programacion.setFechaSiguienteEjecucion(programacionService.fechaSiguienteEjecucion(programacion));
                    programacionService.modify(programacion);
                    meta4IcmWsCalcIncomeSessionService.periodo().stream().forEach(periodo -> {
                        runProgramacion.getRunProgramacionPeriodo().add(RunProgramacionPeriodoDto.builder().periodo(periodo).build());
                    });
                });
        return result;
    }

}