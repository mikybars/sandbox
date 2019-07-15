package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

    @Autowired
    private TareaLocalizacionPresenciaMapper mapper;

    @Autowired
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

    @Override
    public List<TareaLocalizacionPresenciaDto> save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto,
            @Valid TareaDto tarea) {
        return mapper.tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
            tareaLocalizacionPresenciaRepositoryCustom.save(
                mapper.presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(dto, tarea)));
    }

    @Override
    public List<TareaLocalizacionPresenciaDto> saveEcommerce(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto,
            @Valid TareaDto tarea) {
        return mapper.tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
            tareaLocalizacionPresenciaRepositoryCustom.save(
                mapper.presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaEcommerce(dto, tarea)));
    }
    
    @Override
    public void updateActivoVacio(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
    }

    @Override
    public void updateActivo(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.updateActivo(runTareaDto);
    }

    @Override
    public void updateActivoEcommerce(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.updateActivoEcommerce(runTareaDto);
    }
    
    @Override
    public void compensar(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.compensar(runTareaDto);
    }

    @Override
    public void totalizar(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTareaDto);
    }

    @Override
    public void compensarEcommerce(@NotNull final RunTareaDto runTareaDto) {
        tareaLocalizacionPresenciaRepositoryCustom.compensarEcommerce(runTareaDto);
    }
}
