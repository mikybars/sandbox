package com.inditex.rrhh.icmclcwb.model.app.run.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;

@Service
@Validated
public class RunServiceImpl implements RunService {

    @Autowired
    private RunTrabajoService trabajoRunService;

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
    public RunTrabajoDto runTrabajo(@NotNull @Positive final Long id) throws Exception {
        TrabajoDto trabajo = trabajoMapper.trabajoToTrabajoDto(trabajoRepository.findOne(id));
        if (trabajo != null && trabajo.getId() != null) {
            trabajo.setTiendas(trabajoTiendaMapper
                    .trabajoTiendaToTrabajoTiendaDto(trabajoTiendaRepository.findByTrabajoId(trabajo.getId())));
            trabajo.setEmpleados(trabajoEmpleadoMapper
                    .trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.findByTrabajoId(trabajo.getId())));
        }
        RunTrabajoDto trabajoRunDto = new RunTrabajoDto();
        trabajoRunDto.setTrabajoDto(trabajo);
        return trabajoRunService.run(trabajoRunDto);
    }

}