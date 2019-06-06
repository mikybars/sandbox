package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

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
import java.util.List;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

    @Autowired
    private TareaLocalizacionPresenciaMapper mapper;

    @Autowired
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepository;

    @Override
    public List<TareaLocalizacionPresenciaDto> save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea) {
        return mapper.tareaLocalizacionPresenciaToTareaLocalizacionPresenciaDto(
            tareaLocalizacionPresenciaRepository.save(
                mapper.presenciasTotalizadoResponseDtoToTareaLocalizacionPresencia(dto, tarea)));
    }
}
