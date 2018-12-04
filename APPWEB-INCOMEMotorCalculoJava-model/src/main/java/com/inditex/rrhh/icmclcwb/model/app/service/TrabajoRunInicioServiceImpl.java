package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajoRun;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunInicioService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;

@Service
@Validated
public class TrabajoRunInicioServiceImpl implements TrabajoRunInicioService {

    @Autowired
    private TrabajoTiendaRepository trabajoTiendaRepository;

    @Autowired
    private TrabajoTiendaMapper trabajoTiendaMapper;

    @Autowired
    private TrabajoEmpleadoRepository trabajoEmpleadoRepository;

    @Autowired
    private TrabajoEmpleadoMapper trabajoEmpleadoMapper;

    @CounterMetric
    @TimerMetric
    @AuditoriaTrabajoRun
    @Override
    public TrabajoRunDto run(@Valid final TrabajoRunDto trabajoRun) throws Exception {
        final TrabajoDto trabajo = trabajoRun.getTrabajoDto();
        trabajo.setTiendas(trabajoTiendaMapper
                .trabajoTiendaToTrabajoTiendaDto(trabajoTiendaRepository.findByTrabajoId(trabajo.getId())));
        trabajo.setEmpleados(trabajoEmpleadoMapper
                .trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.findByTrabajoId(trabajo.getId())));
        return trabajoRun;
    }

}