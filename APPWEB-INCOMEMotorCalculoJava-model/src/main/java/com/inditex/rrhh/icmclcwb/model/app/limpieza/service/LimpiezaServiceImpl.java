package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class LimpiezaServiceImpl implements LimpiezaService {

    @Autowired
    private LimpiezaRepositoryCustom limpiezaRepositoryCustom;

    @Override
    public void runTarea(@NotNull @Valid final TareaDto tarea) {
        limpiezaRepositoryCustom.limpieza(tarea);
        limpiezaRepositoryCustom.consolidar(tarea);
    }

}
