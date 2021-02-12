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
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.FaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionRepositoryCustom;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class TareaFaseAccionServiceImpl implements TareaFaseAccionService {

    @Autowired
    private TareaFaseAccionRepositoryCustom tareaFaseAccionRepositoryCustom;

    @Autowired
    private TareaFaseAccionRepository tareaFaseAccionRepository;

    @Autowired
    private TareaFaseAccionMapper tareaFaseAccionMapper;

    @Autowired
    private FaseAccionService faseAccionService;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Override
    public List<TareaFaseAccionDto> save(
            @Valid @NotNull @NotEmpty final List<TareaFaseAccionDto> tareaFaseAccion) {
        return this.tareaFaseAccionMapper
            .tareaFaseAccionToTareaFaseAccionDto(
                    this.tareaFaseAccionRepositoryCustom.save(this.tareaFaseAccionMapper
                        .tareaFaseAccionDtoToTareaFaseAccion(tareaFaseAccion)));
    }

    @Override
    public TareaFaseAccionDto findById(@Valid @NotNull @Positive final Long idTareaFaseAccion) {
        return this.tareaFaseAccionRepositoryCustom.findById(idTareaFaseAccion);
    }

    @Override
    public List<TareaFaseAccionDto> saveAll(@Valid @NotNull @NotEmpty final List<TareaFaseAccionDto> tareaFaseAccion) {
        return this.tareaFaseAccionMapper.tareaFaseAccionToTareaFaseAccionDto(this.tareaFaseAccionRepository
            .saveAll(this.tareaFaseAccionMapper.tareaFaseAccionDtoToTareaFaseAccion(tareaFaseAccion)));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void create(@Valid @NotNull final RunTareaDto runTareaDto) {
        final TareaDto tareaDto = runTareaDto.getTarea();
        final List<TareaFaseDto> tareaFaseDto = this.tareaFaseService.findTareaFaseDtoByIdTarea(tareaDto.getId());
        this.save(tareaFaseDto.stream().map(x -> {
            final List<FaseAccionDto> faseAccion = this.faseAccionService
                .findByIdFase(x.getIdFase());
            return faseAccion.stream().map(y -> {
                return TareaFaseAccionDto.builder()
                    .idAccion(y.getIdAccion())
                    .activo(Boolean.TRUE)
                    .idEstadoTareaFaseAccion(EstadoTareaFaseAccionEnum.PENDIENTE.getId())
                    .fechaHoraCreacion(LocalDateTime.now())
                    .idPuntoEjecucion(y.getIdPuntoEjecucion())
                    .idTareaFase(x.getId())
                    .build();
            }).collect(Collectors.toList());
        }).flatMap(List::stream).collect(Collectors.toList()));
    }

    @Override
    public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(
            @NotNull final Long idTarea, @NotNull final Integer idFase, @NotNull final Integer idPuntoEjecucion,
            @NotNull final Long peso) {
        return this.tareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(
                idTarea,
                idFase, idPuntoEjecucion, peso);
    }

    @Override
    public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucionAndPeso(
            @NotNull final Long idTarea, @NotNull final Integer idFase, @NotNull final Integer idAccion,
            @NotNull final Integer idPuntoEjecucion,
            @NotNull final Long peso) {
        return this.tareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(
                idTarea,
                idFase, idPuntoEjecucion, peso);
    }

    @Override
    public List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(
            @NotNull final Long idTarea, @NotNull final Integer idFase, @NotNull final Integer idPuntoEjecucion) {
        return this.tareaFaseAccionRepositoryCustom.findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(idTarea,
                idFase, idPuntoEjecucion);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaInicio(@Valid @NotNull final TareaFaseAccionDto tareaFaseAccionDto) {
        this.tareaFaseAccionRepositoryCustom.updateFechaInicio(tareaFaseAccionDto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFinAndEstado(@Valid @NotNull final TareaFaseAccionDto tareaFaseAccionDto,
            @Valid @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
        this.tareaFaseAccionRepositoryCustom.updateFechaFinAndEstado(tareaFaseAccionDto, estadoTareaFaseAccionDto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaInicioAndFechaFinAndEstado(@Valid @NotNull final TareaFaseAccionDto tareaFaseAccionDto,
            @Valid @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
        this.tareaFaseAccionRepositoryCustom.updateFechaFinAndEstado(tareaFaseAccionDto, estadoTareaFaseAccionDto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaInicioAndFechaFinAndEstadoAndActivoByIdTareaFaseAndEstadoActual(
            @Valid @NotNull final TareaFaseDto tareaFaseDto,
            @Valid @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
            @Valid @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
        this.tareaFaseAccionRepositoryCustom.updateFechaFinAndEstadoAndActivoByIdTareaFaseAndEstadoActual(tareaFaseDto,
                estadoTareaFaseAccionActualDto, estadoTareaFaseAccionDto);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Integer countReintentosByIdTareaAndIdAccionAndIdEstado(
            @NotNull final TareaFaseAccionDto tareaFaseAccionDto,
            @NotNull final TareaFaseDto tareaFaseDto) {
        return this.tareaFaseAccionRepositoryCustom.countReintentosByIdTareaAndIdAccionAndIdEstado(tareaFaseAccionDto,
                tareaFaseDto);
    }

}
