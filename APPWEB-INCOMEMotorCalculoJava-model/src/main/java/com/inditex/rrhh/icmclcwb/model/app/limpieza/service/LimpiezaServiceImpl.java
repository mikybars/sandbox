package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class LimpiezaServiceImpl implements LimpiezaService {

    @Autowired
    private LimpiezaRepositoryCustom limpiezaRepositoryCustom;

    @Override
    public void run() {
        // TODO Obtener tareas pendientes de limpieza
        Long minId = limpiezaRepositoryCustom.findMinId();
        List<Long> ids = limpiezaRepositoryCustom.findIds(minId);
        // TODO Enviar cada id a la cola de limpieza
    }

    @Override
    public void clean(@Positive @NotNull Long id) {
        // TODO Limpiar datos obsoletos de BBDD
        limpiezaRepositoryCustom.limpieza(id);
        limpiezaRepositoryCustom.consolidar(id);
    }

}
