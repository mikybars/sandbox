package com.inditex.rrhh.icmclcwb.model.app.run.tarea.regularizar.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.service.RunTareaRegularizarCalculoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

@Service
@Validated
public class RunTareaRegularizarCalculoServiceImpl implements RunTareaRegularizarCalculoService {

    @Autowired
    private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

    @Override
    public void regularizarCalculoMejorOpcion(@Valid RunTareaDto runTarea) {
        tareaCalculoRepositoryCustom.regularizarMejorOpcion(runTarea.getTarea());
    }

}
