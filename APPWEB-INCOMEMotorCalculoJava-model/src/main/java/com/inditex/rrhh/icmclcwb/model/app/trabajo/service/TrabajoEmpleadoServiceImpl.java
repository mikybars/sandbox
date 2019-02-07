package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoEmpleadoService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoEmpleadoRepository;

@Service
@Validated
public class TrabajoEmpleadoServiceImpl implements TrabajoEmpleadoService {

    @Autowired
    private TrabajoEmpleadoRepository trabajoEmpleadoRepository;

    @Autowired
    private TrabajoEmpleadoMapper trabajoEmpleadoMapper;

    @Override
    public List<TrabajoEmpleadoDto> findByTrabajo(@Valid TrabajoDto trabajo) {
        return trabajoEmpleadoMapper
                .trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.findByTrabajoId(trabajo.getId()));
    }

    @Override
    public List<TrabajoEmpleadoDto> createTrabajoEmpleado(@Valid TrabajoDto trabajo,
            List<TrabajoEmpleadoDto> trabajoEmpleado) {
        return trabajoEmpleadoMapper.trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.saveAll(
                trabajoEmpleadoMapper.mergeTrabajoEmpleadoDtoAndTrabajoDtoToTrabajoEmpleado(trabajoEmpleado, trabajo)));
    }

}