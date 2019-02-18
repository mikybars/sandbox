package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaRepository;
import com.inditex.rrhh.icmclcwb.ms.SenderTarea;

@Service
@Validated
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private TareaMapper tareaMapper;

    @Autowired
    private TareaTiendaService tareaTiendaService;

    @Autowired
    private TareaEmpleadoService tareaEmpleadoService;

    @Autowired
    private SenderTarea senderTarea;

    @Override
    public TareaDto createTarea(@Valid final TareaDto tarea) {
        tarea.setFechaCreacion(LocalDateTime.now());
        tarea.setEstado(EstadoTareaEnum.PENDIENTE_DATOS.getDto());
        if (StringUtils.isBlank(tarea.getIdUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUsername())) {
                tarea.setIdUsuario(userSSO.getUsername());
            }
        }
        TareaDto result = tareaMapper
                .tareaToTareaDto(tareaRepository.save(tareaMapper.tareaDtoToTarea(tarea)));
        if (CollectionUtils.isNotEmpty(tarea.getTiendas())) {
            result.setTiendas(tareaTiendaService.createTareaTienda(result, tarea.getTiendas()));
        } else if (CollectionUtils.isNotEmpty(tarea.getEmpleados())) {
            result.setEmpleados(tareaEmpleadoService.createTareaEmpleado(result, tarea.getEmpleados()));
        }
        senderTarea.send(result);
        return result;
    }

    @Override
    public TareaDto modifyTarea(@Valid final TareaDto tarea) {
        return tareaMapper.tareaToTareaDto(tareaRepository.save(tareaMapper.tareaDtoToTarea(tarea)));
    }

    @Override
    public TareaDto modifyEstadoTarea(@Valid final TareaDto tarea, @Valid final EstadoTareaDto estado) {
        tarea.setEstado(estado);
        return modifyTarea(tarea);
    }
    
    @Override
    public TareaDto modifyEstadoTareaInicial(@Valid TareaDto tarea, @Valid EstadoTareaDto estado) {
        tarea.setFechaInicioTarea(LocalDateTime.now());
        return modifyEstadoTarea(tarea, estado);
    }

    @Override
    public TareaDto modifyEstadoTareaFinal(@Valid TareaDto tarea, @Valid EstadoTareaDto estado) {
        tarea.setFechaFinTarea(LocalDateTime.now());
        return modifyEstadoTarea(tarea, estado);
    }

    @Override
    public TareaDto findTarea(@NotNull @Positive final Long id) {
        TareaDto tarea = tareaMapper.tareaToTareaDto(tareaRepository.findById(id).get());
        tarea.setTiendas(tareaTiendaService.findByTarea(tarea));
        tarea.setEmpleados(tareaEmpleadoService.findByTarea(tarea));
        return tarea;
    }

    @Override
    public List<TareaDto> findAllTarea() {
        return tareaMapper.tareaToTareaDto(tareaRepository.findAll());
    }

}