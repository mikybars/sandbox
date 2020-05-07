package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

    @Autowired
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

    @Override
    public void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
    }

    @Override
    public void compensar(@Valid @NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.compensar(runTareaDto);
    }

    @Override
    public void totalizar(@Valid @NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTareaDto);
    }

    @Override
    public void totalizarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerce(runTareaDto);
    }

    @Override
    public void compensarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.compensarEcommerce(runTareaDto);
    }

    @Override
    public void totalizarEmpleadosPorVenta(@Valid @NotNull RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.totalizarEmpleadosPorVenta(runTareaDto);
    }

}
