package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class LimpiezaServiceImpl implements LimpiezaService {

    @Override
    public void run() {
        // TODO Limpiar datos obsoletos de BBDD
    }

}
