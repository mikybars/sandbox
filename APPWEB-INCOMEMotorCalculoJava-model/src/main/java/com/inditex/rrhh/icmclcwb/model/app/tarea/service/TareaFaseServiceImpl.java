/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.FaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseRepositoryCustom;

@Service
@Validated
public class TareaFaseServiceImpl implements TareaFaseService {

    @Autowired
    private TareaFaseRepositoryCustom tareaFaseRepositoryCustom;

    @Autowired
    private TareaFaseRepository tareaFaseRepository;

    @Autowired
    private TareaFaseMapper tareaFaseMapper;

    @Autowired
    private FaseService faseService;

    @Override
    public List<TareaFaseDto> findAll() {
        return this.tareaFaseMapper.tareaFaseToTareaFaseDto(this.tareaFaseRepository.findAll());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public List<TareaFaseDto> create(@Valid @NotNull final RunTareaDto runTareaDto) {
        final TareaDto tareaDto = runTareaDto.getTarea();
        return this.save(this.faseService.findAll()
            .stream()
            .map(x -> TareaFaseDto.builder()
                .idFase(x.getId())
                .activo(Boolean.TRUE)
                .idTarea(tareaDto.getId())
                .estadoTareaFase(EstadoTareaFaseEnum.PENDIENTE.getDto())
                .fechaHoraCreacion(LocalDateTime.now())
                .build())
            .collect(Collectors.toList()));

    }

    @Override
    public List<TareaFaseDto> save(
            @Valid @NotNull @NotEmpty final List<TareaFaseDto> tareaFase) {
        return this.tareaFaseMapper
            .tareaFaseToTareaFaseDto(
                    this.tareaFaseRepositoryCustom.save(this.tareaFaseMapper
                        .tareaFaseDtoToTareaFase(tareaFase)));
    }

    @Override
    public TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(@NotNull final Long idTarea,
            @NotNull final Integer idFase) {
        return this.tareaFaseRepositoryCustom.findTareaFaseDtoByIdTareaAndIdFase(idTarea, idFase);
    }

    @Override
    public List<TareaFaseDto> findTareaFaseDtoByIdTarea(@NotNull final Long idTarea) {
        return this.tareaFaseRepositoryCustom.findTareaFaseDtoByIdTarea(idTarea);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaInicio(@Valid @NotNull final TareaFaseDto tareaFaseDto) {
        this.tareaFaseRepositoryCustom.updateFechaInicio(tareaFaseDto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
            @Valid @NotNull final TareaDto tareaDto,
            @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseActualDto,
            @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseDto) {
        this.tareaFaseRepositoryCustom.updateFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(tareaDto,
                estadoTareaFaseActualDto,
                estadoTareaFaseDto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFinAndEstado(
            @Valid @NotNull final TareaFaseDto tareaFaseDto,
            @Valid @NotNull final EstadoTareaFaseDto estadoTareaFaseDto) {
        this.tareaFaseRepositoryCustom.updateFechaFinAndEstado(tareaFaseDto, estadoTareaFaseDto);
    }

}
