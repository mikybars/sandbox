package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaPresenciaSeccionRepository;

@Service
@Validated
public class TrabajoTiendaPresenciaSeccionServiceImpl implements TrabajoTiendaPresenciaSeccionService {
    
    @Autowired
    private TrabajoTiendaPresenciaSeccionRepository trabajoTiendaPresenciaSeccionRepository;
    
    @Override
    public void pivot(@Valid final TrabajoDto trabajoDto) throws Exception {
        trabajoTiendaPresenciaSeccionRepository.save(trabajoDto);
    }

}
