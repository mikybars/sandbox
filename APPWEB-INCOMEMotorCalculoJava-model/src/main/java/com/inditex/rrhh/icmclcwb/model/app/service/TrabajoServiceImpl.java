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
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaMapper;
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
    private TrabajoTiendaMapper trabajoTiendaMapper;

    @Autowired
    private TrabajoEmpleadoRepository trabajoEmpleadoRepository;

    @Autowired
    private TrabajoEmpleadoMapper trabajoEmpleadoMapper;

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
            result.setTiendas(
                    trabajoTiendaMapper.trabajoTiendaToTrabajoTiendaDto(trabajoTiendaRepository.save(trabajoTiendaMapper
                            .mergeTrabajoTiendaDtoAndTrabajoDtoToTrabajoTienda(trabajo.getTiendas(), result))));
        } else if (CollectionUtils.isNotEmpty(trabajo.getEmpleados())) {
            result.setEmpleados(trabajoEmpleadoMapper
                    .trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.save(trabajoEmpleadoMapper
                            .mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(trabajo.getEmpleados(), result))));
        }
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