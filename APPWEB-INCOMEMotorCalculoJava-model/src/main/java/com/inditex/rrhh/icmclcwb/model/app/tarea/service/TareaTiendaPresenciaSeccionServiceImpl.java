package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaPresenciaSeccionRepository;

@Service
@Validated
public class TareaTiendaPresenciaSeccionServiceImpl implements TareaTiendaPresenciaSeccionService {
    
    @Autowired
    private TareaTiendaPresenciaSeccionRepository tareaTiendaPresenciaSeccionRepository;
    
    @Override
    public void pivot(@Valid final TareaDto tareaDto) {
        tareaTiendaPresenciaSeccionRepository.save(tareaDto);
    }

}
