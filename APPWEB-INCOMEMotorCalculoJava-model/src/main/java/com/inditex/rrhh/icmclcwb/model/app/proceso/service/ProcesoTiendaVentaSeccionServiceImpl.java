package com.inditex.rrhh.icmclcwb.model.app.proceso.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoTiendaVentaSeccionRepository;

@Service
@Validated
public class ProcesoTiendaVentaSeccionServiceImpl implements ProcesoTiendaVentaSeccionService {
    
    @Autowired
    private ProcesoTiendaVentaSeccionRepository procesoTiendaVentaSeccionRepository;

    @Override
    public void pivot(@Valid final ProcesoDto procesoDto) {
        procesoTiendaVentaSeccionRepository.save(procesoDto);
    }
}
