package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaSeccionRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresenciaSeccionServiceImpl implements TareaLocalizacionPresenciaSeccionService {

    @Autowired
    private TareaLocalizacionPresenciaSeccionMapper mapper;

    @Autowired
    private TareaLocalizacionPresenciaSeccionRepositoryCustom tareaLocalizacionPresenciaSeccionRepositoryCustom;

    @Override
    public List<TareaLocalizacionPresenciaSeccionDto> save(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
            @Valid final TareaDto tarea) {
        return mapper
                .tareaLocalizacionPresenciaSeccionToTareaLocalizacionPresenciaSeccionDto(tareaLocalizacionPresenciaSeccionRepositoryCustom
                        .save(mapper.presenciasTotalizadoResponseDtoToTareaLocalizacionPresenciaSeccion(dto, tarea)));
    }

    @Override
    public void compensar(@Valid final RunTareaDto runTarea) {
        tareaLocalizacionPresenciaSeccionRepositoryCustom.compensar(runTarea);
    }
    
    @Override
    public void updateActivo(@Valid final RunTareaDto runTarea) {
        tareaLocalizacionPresenciaSeccionRepositoryCustom.updateActivo(runTarea);
    }
}
