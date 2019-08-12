package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

    @Autowired
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;
    
    @Override
    public void updateActivoVacio(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
    }
    
    @Override
    public void compensar(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.compensar(runTareaDto);
        tareaLocalizacionPresenciaRepositoryCustom.incluirMinutosDesplazamientoDestino(runTareaDto);
        tareaLocalizacionPresenciaRepositoryCustom.incluirMinutosDesplazamientoOrigen(runTareaDto);
    }

    @Override
    public void totalizar(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTareaDto);
    }

    @Override
    public void compensarEcommerce(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.compensarEcommerce(runTareaDto);
        tareaLocalizacionPresenciaRepositoryCustom.incluirMinutosEcommerceDesplazamientoDestino(runTareaDto);
        tareaLocalizacionPresenciaRepositoryCustom.incluirMinutosEcommerceDesplazamientoOrigen(runTareaDto);
    }
}
