package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.service.RunLimpiezaService;

@Service
@Validated
public class RunLimpiezaServiceImpl implements RunLimpiezaService {

    @Autowired
    private LimpiezaService limpiezaService;

    @Transactional
    @Override
    public void run() {
        limpiezaService.run();
    }

}