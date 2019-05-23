package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

    @Autowired
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPresenciaMapper mapper;
    
    @Override
    public List<TareaLocalizacionPresenciaDto> save(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
            @Valid final TareaDto tarea) {
        return mapper
                .tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(tareaLocalizacionPresenciaRepositoryCustom
                        .save(mapper.presenciasTotalizadoResponseDtoToTareaLocalizacionSeccion(dto, tarea)));
    }
}
