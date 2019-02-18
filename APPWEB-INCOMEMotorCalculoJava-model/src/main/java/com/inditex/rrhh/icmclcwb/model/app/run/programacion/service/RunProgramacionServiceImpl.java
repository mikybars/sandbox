package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.programacion.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
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
    private TareaService tareaService;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Override
    public List<TareaDto> run() {
        List<TareaDto> result = new ArrayList<>();
        programacionMapper
                .programacionToProgramacionDto(
                        programacionRepository.findByFechaSiguienteEjecucionBeforeAndActivaTrue(new Date()))
                .stream().forEach(programacion -> {
                    programacion.setFechaUltimaEjecucion(LocalDateTime.now());
                    programacion.setFechaSiguienteEjecucion(programacionService.fechaSiguienteEjecucion(programacion));
                    ProgramacionDto programacionModify = programacionService.modifyProgramacion(programacion);
                    meta4IcmWsCalcIncomeSessionService.periodo().stream().forEach(periodo -> {
						TareaDto tarea = tareaMapper.programacionDtoToTareaDto(programacionModify);
                        tarea.setFechaInicioPeriodo(periodo.getFechaInicioPeriodo());
                        tarea.setFechaFinPeriodo(periodo.getFechaFinPeriodo());
                        result.add(tareaService.createTarea(tarea));
                    });
                });
        return result;
    }

}