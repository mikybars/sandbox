package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaValidarService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaValidarRepositoryCustom;

@Service
@Validated
public class TareaValidarServiceImpl implements TareaValidarService {
    
    @Autowired
    private TareaValidarRepositoryCustom tareaValidarRepositoryCustom;

    @Override
    public List<String> checkDuplicatedEmpleados(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.checkDuplicatedEmpleados(idTarea);
    }

    @Override
    public List<String> checkDuplicatedTiendas(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.checkDuplicatedTiendas(idTarea);
    }

    @Override
    public List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.checkDuplicatedTiendasHistorico(idTarea);
    }
    
    @Override
    public Integer countEmpleados(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countEmpleados(idTarea);
    }

    @Override
    public Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countEmpleadosHistorico(idTarea);
    }

    @Override
    public Integer countTiendas(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendas(idTarea);
    }

    @Override
    public Integer countTiendasHistorico(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendasHistorico(idTarea);
    }

    @Override
    public Integer countEstructuras(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countEstructuras(idTarea);
    }

    @Override
    public Integer countTiendaPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendaPresenciaSeccion(idTarea);
    }

    @Override
    public Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendaEmpleadoPresenciaSeccion(idTarea);
    }

    @Override
    public Integer countTiendaVentaSeccion(@NotNull @Positive Long idTarea) {
        return tareaValidarRepositoryCustom.countTiendaVentaSeccion(idTarea);
    }

}
