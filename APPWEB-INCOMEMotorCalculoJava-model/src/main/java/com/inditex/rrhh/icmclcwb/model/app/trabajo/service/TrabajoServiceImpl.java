package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

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
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.ms.SenderTrabajo;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaService trabajoTiendaService;

    @Autowired
    private TrabajoEmpleadoService trabajoEmpleadoService;

    @Autowired
    private SenderTrabajo senderTrabajo;

    @Override
    public TrabajoDto createTrabajo(@Valid final TrabajoDto trabajo) {
        trabajo.setFechaCreacion(LocalDateTime.now());
        trabajo.setEstado(AppConstants.EstadoTrabajoEnum.PENDIENTE_DATOS.getDto());
        if (StringUtils.isBlank(trabajo.getIdUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUsername())) {
                trabajo.setIdUsuario(userSSO.getUsername());
            }
        }
        TrabajoDto result = trabajoMapper
                .trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
        if (CollectionUtils.isNotEmpty(trabajo.getTiendas())) {
            result.setTiendas(trabajoTiendaService.createTrabajoTienda(result, trabajo.getTiendas()));
        } else if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
            result.setEmpleados(trabajoEmpleadoService.createTrabajoEmpleado(result, trabajo.getEmpleados()));
        }
        senderTrabajo.send(result);
        return result;
    }

    @Override
    public TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo) {
        return trabajoMapper.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
    }

    @Override
    public TrabajoDto modifyEstadoTrabajo(@Valid final TrabajoDto trabajo, @Valid final EstadoTrabajoDto estado) {
        trabajo.setEstado(estado);
        return modifyTrabajo(trabajo);
    }
    
    @Override
    public TrabajoDto modifyEstadoTrabajoInicial(@Valid TrabajoDto trabajo, @Valid EstadoTrabajoDto estado) {
        trabajo.setFechaInicioTrabajo(LocalDateTime.now());
        return modifyEstadoTrabajo(trabajo, estado);
    }

    @Override
    public TrabajoDto modifyEstadoTrabajoFinal(@Valid TrabajoDto trabajo, @Valid EstadoTrabajoDto estado) {
        trabajo.setFechaFinTrabajo(LocalDateTime.now());
        return modifyEstadoTrabajo(trabajo, estado);
    }

    @Override
    public TrabajoDto findTrabajo(@NotNull @Positive final Long id) {
        TrabajoDto trabajo = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findById(id).get());
        trabajo.setTiendas(trabajoTiendaService.findByTrabajo(trabajo));
        trabajo.setEmpleados(trabajoEmpleadoService.findByTrabajo(trabajo));
        return trabajo;
    }

    @Override
    public List<TrabajoDto> findAllTrabajo() {
        return trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findAll());
    }

}