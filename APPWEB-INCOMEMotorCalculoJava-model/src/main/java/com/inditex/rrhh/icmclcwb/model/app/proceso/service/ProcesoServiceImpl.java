package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

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
import com.inditex.rrhh.icmclcwb.api.app.proceso.EstadoProcesoEnum;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.EstadoProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.proceso.mapper.ProcesoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoRepository;
import com.inditex.rrhh.icmclcwb.ms.app.proceso.SenderProceso;

@Service
@Validated
public class ProcesoServiceImpl implements ProcesoService {

    @Autowired
    private ProcesoRepository procesoRepository;

    @Autowired
    private ProcesoMapper procesoMapper;

    @Autowired
    private ProcesoTiendaService procesoTiendaService;

    @Autowired
    private ProcesoEmpleadoService procesoEmpleadoService;

    @Autowired
    private SenderProceso senderProceso;

    @Override
    public ProcesoDto createProceso(@Valid final ProcesoDto proceso) {
        proceso.setFechaCreacion(LocalDateTime.now());
        proceso.setEstado(EstadoProcesoEnum.PENDIENTE_RECOLECTAR.getDto());
        if (StringUtils.isBlank(proceso.getIdUsuario())) {
            UserSSO userSSO = SsoUtils.getUserSSO();
            if (StringUtils.isNotBlank(userSSO.getUsername())) {
                proceso.setIdUsuario(userSSO.getUsername());
            }
        }
        ProcesoDto result = procesoMapper
                .procesoToProcesoDto(procesoRepository.save(procesoMapper.procesoDtoToProceso(proceso)));
        if (CollectionUtils.isNotEmpty(proceso.getTiendas())) {
            result.setTiendas(procesoTiendaService.createProcesoTienda(result, proceso.getTiendas()));
        } else if (CollectionUtils.isNotEmpty(proceso.getEmpleados())) {
            result.setEmpleados(procesoEmpleadoService.createProcesoEmpleado(result, proceso.getEmpleados()));
        }
        senderProceso.send(result);
        return result;
    }

    @Override
    public ProcesoDto modifyProceso(@Valid final ProcesoDto proceso) {
        return procesoMapper.procesoToProcesoDto(procesoRepository.save(procesoMapper.procesoDtoToProceso(proceso)));
    }

    @Override
    public ProcesoDto modifyEstadoProceso(@Valid final ProcesoDto proceso, @Valid final EstadoProcesoDto estado) {
        proceso.setEstado(estado);
        return modifyProceso(proceso);
    }
    
    @Override
    public ProcesoDto modifyEstadoProcesoInicial(@Valid ProcesoDto proceso, @Valid EstadoProcesoDto estado) {
        proceso.setFechaInicioProceso(LocalDateTime.now());
        return modifyEstadoProceso(proceso, estado);
    }

    @Override
    public ProcesoDto modifyEstadoProcesoFinal(@Valid ProcesoDto proceso, @Valid EstadoProcesoDto estado) {
        proceso.setFechaFinProceso(LocalDateTime.now());
        return modifyEstadoProceso(proceso, estado);
    }

    @Override
    public ProcesoDto findProceso(@NotNull @Positive final Long id) {
        ProcesoDto proceso = procesoMapper.procesoToProcesoDto(procesoRepository.findById(id).get());
        proceso.setTiendas(procesoTiendaService.findByProceso(proceso));
        proceso.setEmpleados(procesoEmpleadoService.findByProceso(proceso));
        return proceso;
    }

    @Override
    public List<ProcesoDto> findAllProceso() {
        return procesoMapper.procesoToProcesoDto(procesoRepository.findAll());
    }

}