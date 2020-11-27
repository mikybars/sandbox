package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.AccionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaPrevalidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPrevalidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import com.inditex.rrhh.icmclcwb.ms.app.tareaprevalidar.SenderTareaPreValidar;

@Validated
@Service
public class TareaPrevalidacionServiceImpl implements TareaPrevalidacionService {

    @Autowired
    private SenderTarea senderTarea;

    @Autowired
    private SenderTareaPreValidar senderTareaPreValidar;

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TareaPrevalidacionMapper tareaPrevalidacionMapper;

    @Autowired
    private TareaPrevalidacionRepository tareaPrevalidacionRepository;

    @Autowired
    private TareaPrevalidacionRepositoryCustom tareaPrevalidacionRepositoryCustom;

    @Override
    public void save(@Valid @NotNull final TareaPrevalidacionDto src,
            @Valid @NotNull final TareaDto tarea) {
        final TareaPrevalidacion flujo = this.tareaPrevalidacionMapper
            .tareaPrevalidacionDtotoTareaPrevalidacion(src, tarea);
        this.tareaPrevalidacionRepository.save(flujo);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public TareaPrevalidacionDto create(@Valid @NotNull final TareaDto tarea) {
        final TareaPrevalidacionDto flujo = this.tareaPrevalidacionRepositoryCustom.findMaxReintento(tarea.getId());
        flujo.setActivo(Boolean.TRUE);
        flujo.setIdEstadoTareaPrevalidacion(EstadoTareaPrevalidacionEnum.EN_CURSO_VALIDACION.getId());
        flujo.setFechaHoraActualizacion(LocalDateTime.now());
        flujo.setFechaHoraCreacion(LocalDateTime.now());
        flujo.setFechaHoraInicio(LocalDateTime.now());
        return this.tareaPrevalidacionMapper.tareaPrevalidaciontoTareaPrevalidacionDto(
                this.tareaPrevalidacionRepository.save(this.tareaPrevalidacionMapper
                    .tareaPrevalidacionDtotoTareaPrevalidacion(flujo, tarea)),
                tarea);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void updateFechaFin(@Valid @NotNull final TareaPrevalidacionDto tareaPrevalidacionDto) {
        this.tareaPrevalidacionRepositoryCustom.updateFechaFin(tareaPrevalidacionDto);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void updateEstado(@Valid @NotNull final TareaPrevalidacionDto tareaPrevalidacionDto,
            @Valid @NotNull final EstadoTareaPrevalidacionDto estado) {
        this.tareaPrevalidacionRepositoryCustom.updateEstado(tareaPrevalidacionDto, estado);
    }

    @Override
    public Boolean checkMaxReintentos(@Valid @NotNull final TareaPrevalidacionDto tareaPrevalidacionDto) {
        return this.tareaPrevalidacionRepositoryCustom.checkMaxReintentos(tareaPrevalidacionDto);
    }

    @Override
    public void send(@Valid @NotNull final TareaPrevalidacionDto prevalidacionDto) {

        if (Boolean.FALSE.equals(this.checkMaxReintentos(prevalidacionDto))) {
            final AccionValidacionDto accion = this.tareaPrevalidacionRepositoryCustom.findAccionValidacion(
                    prevalidacionDto.getIdTarea(),
                    prevalidacionDto.getId());
            if (accion != null) {
                switch (accion.getId()) {
                    case 3:
                        this.senderTareaPreValidar.sendWithDelay(this.tareaService.find(prevalidacionDto.getIdTarea()),
                                accion.getDelayTime());
                        break;
                    case 4:
                        this.senderTareaPreValidar.send(this.tareaService.find(prevalidacionDto.getIdTarea()));
                        break;
                    default:
                        break;
                }
            } else {
                this.senderTarea.send(this.tareaService.find(prevalidacionDto.getIdTarea()));
            }
        } else {
            this.updateEstado(prevalidacionDto,
                    EstadoTareaPrevalidacionEnum.ERROR.getDto());
        }
    }

}
