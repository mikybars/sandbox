package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDto;
import com.inditex.rrhh.icmclcwb.api.app.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private TrabajoRunService trabajoRunService;

    @Autowired
    private TrabajoMapper trabajoMapper;

    @Autowired
    private TrabajoRepository trabajoRepository;
    
    @Autowired
    private TrabajoTiendaRepository trabajoTiendaRepository;

    @Autowired
    private TrabajoTiendaMapper trabajoTiendaMapper;

    @Autowired
    private TrabajoEmpleadoRepository trabajoEmpleadoRepository;

    @Autowired
    private TrabajoEmpleadoMapper trabajoEmpleadoMapper;

    @Override
    public TrabajoRunDto runTrabajo(@NotNull @Positive final Long id) throws Exception {
        TrabajoDto trabajo = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id));
        trabajo.setTiendas(trabajoTiendaMapper
                .trabajoTiendaToTrabajoTiendaDto(trabajoTiendaRepository.findByTrabajoId(trabajo.getId())));
        trabajo.setEmpleados(trabajoEmpleadoMapper
                .trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.findByTrabajoId(trabajo.getId())));
        TrabajoRunDto trabajoRunDto = new TrabajoRunDto();
        trabajoRunDto.setTrabajoDto(trabajo);
        return trabajoRunService.run(trabajoRunDto);
    }

}