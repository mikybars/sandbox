package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaVentaSeccionRepositoryCustom;

@Service
@Validated
public class TareaTiendaVentaSeccionServiceImpl implements TareaTiendaVentaSeccionService {
    
    @Autowired
    private TareaTiendaVentaSeccionRepositoryCustom tareaTiendaVentaSeccionRepository;

    @Override
    public void pivot(@Valid final TareaDto tareaDto) {
        tareaTiendaVentaSeccionRepository.save(tareaDto);
    }
}
