package com.inditex.rrhh.icmclcwb.model.app.run.mantenimiento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.dto.RunMantenimientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.limpieza.service.RunMantenimientoLimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.mantenimiento.service.RunMantenimientoService;

@Service
@Validated
public class RunMantenimientoServiceImpl implements RunMantenimientoService {

    @Autowired
    private RunMantenimientoLimpiezaService runMantenimientoLimpiezaService;

    @Transactional
    @Override
    public RunMantenimientoDto run() {
        return RunMantenimientoDto.builder().runMantenimientoLimpieza(runMantenimientoLimpiezaService.run()).build();
    }

}