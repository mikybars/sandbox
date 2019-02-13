package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoTiendaVentaSeccionRepository;

@Service
@Validated
public class TrabajoTiendaVentaSeccionServiceImpl implements TrabajoTiendaVentaSeccionService {
    
    @Autowired
    private TrabajoTiendaVentaSeccionRepository trabajoTiendaVentaSeccionRepository;

    @Override
    public void pivot(@Valid final TrabajoDto trabajoDto) {
        trabajoTiendaVentaSeccionRepository.save(trabajoDto);
    }
}
