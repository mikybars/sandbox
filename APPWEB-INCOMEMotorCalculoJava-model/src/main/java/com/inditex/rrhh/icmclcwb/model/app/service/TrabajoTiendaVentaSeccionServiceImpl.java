package com.inditex.rrhh.icmclcwb.model.app.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaVentaSeccionRepository;

@Service
@Validated
public class TrabajoTiendaVentaSeccionServiceImpl implements TrabajoTiendaVentaSeccionService {
    
    @Autowired
    private TrabajoTiendaVentaSeccionRepository trabajoTiendaVentaSeccionRepository;

    @Override
    public void pivot(@Valid final TrabajoDto trabajoDto) throws Exception {
        trabajoTiendaVentaSeccionRepository.save(trabajoDto);
    }
}
