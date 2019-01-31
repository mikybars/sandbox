package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaRepository;

@Service
@Validated
public class TrabajoTiendaServiceImpl implements TrabajoTiendaService {

    @Autowired
    private TrabajoTiendaRepository trabajoTiendaRepository;

    @Autowired
    private TrabajoTiendaMapper trabajoTiendaMapper;

    @Override
    public List<TrabajoTiendaDto> findByTrabajo(@Valid TrabajoDto trabajo) {
        return trabajoTiendaMapper
                .trabajoTiendaToTrabajoTiendaDto(trabajoTiendaRepository.findByTrabajoId(trabajo.getId()));
    }

    @Override
    public List<TrabajoTiendaDto> createTrabajoTienda(@Valid TrabajoDto trabajo, List<TrabajoTiendaDto> trabajoTienda) {
        return trabajoTiendaMapper.trabajoTiendaToTrabajoTiendaDto(trabajoTiendaRepository
                .save(trabajoTiendaMapper.mergeTrabajoTiendaDtoAndTrabajoDtoToTrabajoTienda(trabajoTienda, trabajo)));
    }

}