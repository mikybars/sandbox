package com.inditex.rrhh.icmclcwb.model.app.run.programacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.programacion.service.ProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionPeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.service.RunProgramacionService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.PageDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.periodo.mapper.PeriodoMapper;

@Service
@Validated
public class RunProgramacionServiceImpl implements RunProgramacionService {

    @Autowired
    private ProgramacionService programacionService;
    
    @Autowired
    private PeriodoMapper periodoMapper;

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
            
            PeriodosRequestDto request = new PeriodosRequestDto();
            request.setPage(new PageDto());
            request.setData(new GenericFilterDto());
            request.getData().setItem(new ArrayList<GenericFilterParametersDto>());

            List<PeriodosResultItemDto> periodos = new ArrayList<>();
            if (TipoAmbitoEnum.SOCIEDAD.getId().equals(programacion.getTipoAmbito().getId())
                    || TipoAmbitoEnum.ORIGEN.getId().equals(programacion.getTipoAmbito().getId())
                    || TipoAmbitoEnum.EMPRESA.getId().equals(programacion.getTipoAmbito().getId())) {
                List<String> idOrigen = programacion.getAmbito().stream().flatMap(e -> e.getOrigen().stream().map(f -> f.getIdOrigen())).collect(Collectors.toList());
                idOrigen.stream().forEach(e -> {
                    request.getData().getItem().add(GenericFilterParametersDto.builder().abierto(Boolean.TRUE.toString()).activo(Boolean.TRUE.toString()).vigente(Boolean.TRUE.toString()).build());
                    request.getData().setIdOrigen(e);   
                    periodos.addAll(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
                });
            } else if (TipoAmbitoEnum.LOCALIZACION.getId().equals(programacion.getTipoAmbito().getId())) {
                List<String> idLocalizacion = programacion.getAmbito().stream().flatMap(e -> e.getLocalizacion().stream().map(f -> f.getIdLocalizacion())).collect(Collectors.toList());
                idLocalizacion.stream().forEach(e-> request.getData().getItem().add(GenericFilterParametersDto.builder().idLugarTrabajo(e).abierto(Boolean.TRUE.toString()).activo(Boolean.TRUE.toString()).vigente(Boolean.TRUE.toString()).build()));
                periodos.addAll(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
            } else if (TipoAmbitoEnum.PERSONA.getId().equals(programacion.getTipoAmbito().getId())) {
                List<String> idPersona = programacion.getAmbito().stream().flatMap(e -> e.getPersona().stream().map(f -> f.getIdPersona())).collect(Collectors.toList());
                idPersona.stream().forEach(e-> request.getData().getItem().add(GenericFilterParametersDto.builder().idEmpleado(e).abierto(Boolean.TRUE.toString()).activo(Boolean.TRUE.toString()).vigente(Boolean.TRUE.toString()).build()));
                periodos.addAll(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
            } else {
                throw new IcmclcwbException("El tipo ambito no esta soportado");
            }
            
            periodoMapper.periodoResultItemDtoToPeriodoDto(periodos).stream().forEach(periodo -> {
                RunProgramacionPeriodoDto runProgramacionPeriodo = RunProgramacionPeriodoDto.builder().periodo(periodo)
                        .trabajo(trabajoService.create(programacion, periodo)).build();
                runProgramacion.getRunProgramacionPeriodo().add(runProgramacionPeriodo);
            });
            result.add(runProgramacion);
        });
        return result;
    }

}