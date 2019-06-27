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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.periodos.dto.PeriodosRequestDto;
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
            RunProgramacionDto runProgramacion = RunProgramacionDto.builder().programacion(programacion)
                    .runProgramacionPeriodo(new ArrayList<>()).build();
            programacionService.updateEjecucion(programacion);
            programacion.getAmbito().stream().forEach(programacionAmbito -> {
                List<String> origen = new ArrayList<>();
                if (TipoAmbitoEnum.SOCIEDAD.getId().equals(programacion.getTipoAmbito().getId())) {
                    // TODO Recuperar los origenes y lanzar las programaciones
                    throw new IcmclcwbException("El tipo ambito no esta soportado");
                } else if (TipoAmbitoEnum.ORIGEN.getId().equals(programacion.getTipoAmbito().getId())
                        || TipoAmbitoEnum.EMPRESA.getId().equals(programacion.getTipoAmbito().getId())
                        || TipoAmbitoEnum.LOCALIZACION.getId().equals(programacion.getTipoAmbito().getId())
                        || TipoAmbitoEnum.PERSONA.getId().equals(programacion.getTipoAmbito().getId())) {
                    origen = programacionAmbito.getOrigen().stream().map(item -> item.getIdOrigen())
                            .collect(Collectors.toList());
                } else {
                    throw new IcmclcwbException("El tipo ambito no esta soportado");
                }
                PeriodosRequestDto request = new PeriodosRequestDto();
                request.setPage(new PageDto());
                request.setData(new GenericFilterDto());
                request.getData().setItem(new ArrayList<GenericFilterParametersDto>());
                // Se usa el primer origen, porque los periodos van por sociedad
                request.getData().setIdOrigen(origen.stream().findFirst().get());
                request.getData().getItem().add(GenericFilterParametersDto.builder().abierto(Boolean.TRUE.toString())
                        .activo(Boolean.TRUE.toString()).vigente(Boolean.TRUE.toString()).build());
                List<PeriodoDto> periodos = periodoMapper
                        .periodoResultItemDtoToPeriodoDto(meta4IcmWsCalcIncomeSessionService.getPeriodos(request));
                periodos.stream().forEach(periodo -> {
                    RunProgramacionPeriodoDto runProgramacionPeriodo = RunProgramacionPeriodoDto.builder()
                            .periodo(periodo).programacionAmbito(programacionAmbito).trabajo(trabajoService
                                    .create(trabajoService.merge(programacion, programacionAmbito, periodo)))
                            .build();
                    runProgramacion.getRunProgramacionPeriodo().add(runProgramacionPeriodo);
                });
            });
            result.add(runProgramacion);
        });
        return result;
    }

}