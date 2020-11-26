/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoValidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionValidacionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPrevalidacionValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionValidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionValidacionRepositoryCustom;

@Validated
@Service
public class TareaPrevalidacionValidacionServiceImpl implements TareaPrevalidacionValidacionService {

    @Autowired
    Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Autowired
    private TareaPrevalidacionValidacionRepository tareaPrevalidacionValidacionRepository;

    @Autowired
    private TareaPrevalidacionValidacionRepositoryCustom tareaPrevalidacionValidacionRepositoryCustom;

    @Autowired
    private TareaPrevalidacionValidacionMapper tareaPrevalidacionValidacionMapper;

    @Override
    public void save(@Valid @NotNull final TareaPrevalidacionValidacionDto src,
            @Valid @NotNull final TareaDto tarea) {
        final TareaPrevalidacionValidacion flujo = this.tareaPrevalidacionValidacionMapper
            .tareaPrevalidacionValidacionDtotoTareaPrevalidacionValidacion(src, tarea);
        this.tareaPrevalidacionValidacionRepository.save(flujo);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void create(@Valid @NotNull final TareaDto tarea, @NotNull final Integer idTipoEstadoValidacion,
            @NotNull final TareaPrevalidacionDto tareaPrevalidacionDto) {
        final List<ValidacionDto> validaciones = this.meta4IcmWsCalcIncomeSessionService
            .configuracionValidacion();
        validaciones.stream().forEach(x -> {
            final TareaPrevalidacionValidacionDto flujo = new TareaPrevalidacionValidacionDto();
            // TODO: Todas estas operaciones habría que gestionarlas desde los enumerados correspondientes
            // cuando exista el campo de meta4 (y en un mapper por ej:
            // validacionDtoAndTareaPrevalidacionDtoToTareaPrevalidacionValidacionDto)
            flujo.setIdTipoEstadoValidacion(x.getIdTipoEstadoValidacion());
            flujo.setIdTipoAccionValidacion(x.getIdTipoAccionValidacion());
            flujo.setIdTipoValidacion(x.getId());
            flujo.setIdPrioridadValidacion(x.getIdPrioridadValidacion());
            flujo.setIdEstadoValidacion(EstadoValidacionEnum.OK.getId());
            flujo.setFechaHoraActualizacion(LocalDateTime.now());
            flujo.setFechaHoraCreacion(LocalDateTime.now());
            flujo.setDelay(x.getDelay());
            flujo.setReintentoDelay(x.getDelayTime());
            flujo.setReintentoMax(x.getMaxReintentos());
            flujo.setIdTareaPrevalidacion(tareaPrevalidacionDto.getId());
            flujo.setId(x.getId());
            this.tareaPrevalidacionValidacionRepository.save(this.tareaPrevalidacionValidacionMapper
                .tareaPrevalidacionValidacionDtotoTareaPrevalidacionValidacion(flujo, tarea));
        });
    }

    @Override
    public TareaPrevalidacionValidacionDto findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(
            @NotNull final Long idTarea,
            @NotNull final Integer idTareaPrevalidacion,
            @NotNull final Integer idTipoValidacion) {
        return this.tareaPrevalidacionValidacionRepositoryCustom
            .findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(idTarea, idTareaPrevalidacion, idTipoValidacion);
    }

    @Override
    public void update(final TareaPrevalidacionValidacionDto tareaPrevalidacionValidacionDto,
            @Valid @NotNull final TareaDto tarea,
            final Integer idEstadoValidacion) {
        this.tareaPrevalidacionValidacionRepositoryCustom.update(idEstadoValidacion,
                tareaPrevalidacionValidacionDto.getIdTareaPrevalidacion(),
                tareaPrevalidacionValidacionDto.getIdTipoValidacion(), tarea.getId());
    }

}
