package com.inditex.rrhh.icmclcwb.model.app.service;

import java.time.LocalDateTime;
import javax.validation.Valid;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.Trabajo;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;
import com.inditex.rrhh.icmclcwb.ms.SenderTrabajo;

@Service
@Validated
public class TrabajoServiceImpl implements TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoTiendaRepository trabajoTiendaRepository;

    @Autowired
    private TrabajoEmpleadoRepository trabajoEmpleadoRepository;

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
        TrabajoDto parent = trabajoMapper
                .trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
        parent.setTiendas(trabajo.getTiendas());
        parent.setEmpleados(trabajo.getEmpleados());
        Trabajo child = trabajoMapper.trabajoDtoToTrabajo(parent);
        if (CollectionUtils.isNotEmpty(child.getTiendas())) {
            child.setTiendas(trabajoTiendaRepository.save(child.getTiendas()));
        } else if (CollectionUtils.isNotEmpty(child.getEmpleados())) {
            child.setEmpleados(trabajoEmpleadoRepository.save(child.getEmpleados()));
        }
        TrabajoDto result = trabajoMapper.trabajoToTrabajoDto(child);
        senderTrabajo.send(result);
        return result;
    }

    @Override
    public TrabajoDto modifyTrabajo(@Valid final TrabajoDto trabajo) {
        return trabajoMapper.trabajoToTrabajoDto(trabajoRepository.save(trabajoMapper.trabajoDtoToTrabajo(trabajo)));
    }

    @Override
    public TrabajoDto modifyEstadoTrabajo(@Valid final EstadoTrabajoDto estado, @Valid final TrabajoDto trabajo) {
        trabajo.setEstado(estado);
        return modifyTrabajo(trabajo);
    }

}