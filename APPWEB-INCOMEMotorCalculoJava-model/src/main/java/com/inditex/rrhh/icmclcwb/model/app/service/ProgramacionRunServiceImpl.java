package com.inditex.rrhh.icmclcwb.model.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.service.Meta4SessionService;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionRunService;
import com.inditex.rrhh.icmclcwb.api.app.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ProgramacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ProgramacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Validated
public class ProgramacionRunServiceImpl implements ProgramacionRunService {

    @Autowired
    private ProgramacionService programacionService;

    @Autowired
    private ProgramacionRepository programacionRepository;

    @Autowired
    private ProgramacionMapper programacionMapper;

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private Meta4SessionService meta4Service;

    @Override
    public List<TrabajoDto> run() {
        List<TrabajoDto> result = new ArrayList<>();
        programacionMapper
                .programacionToProgramacionDto(
                        programacionRepository.findByFechaSiguienteEjecucionBeforeAndActivaTrue(new Date()))
                .stream().forEach(programacion -> {
                    programacion.setFechaUltimaEjecucion(LocalDateTime.now());
                    programacion.setFechaSiguienteEjecucion(programacionService.fechaSiguienteEjecucion(programacion));
                    ProgramacionDto programacionModify = programacionService.modifyProgramacion(programacion);
                    meta4Service.periodo().stream().forEach(periodo -> {
                        TrabajoDto trabajo = trabajoMapper.programacionDtoToTrabajoDto(programacionModify);
                        trabajo.setFechaInicioPeriodo(periodo.getFechaInicioPeriodo());
                        trabajo.setFechaFinPeriodo(periodo.getFechaFinPeriodo());
                        result.add(trabajoService.createTrabajo(trabajo));
                    });
                });
        return result;
    }

}