package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionSeccionPresenciaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaLocalizacionSeccionPresenciaServiceImpl implements TareaLocalizacionSeccionPresenciaService {

    @Autowired
    private TareaLocalizacionSeccionPresenciaMapper mapper;

    @Autowired
    private TareaLocalizacionSeccionPresenciaRepositoryCustom tareaLocalizacionSeccionPresenciaRepository;

    @Override
    public List<TareaLocalizacionSeccionPresenciaDto> save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea) {
        return mapper.tareaLocalizacionSeccionPresenciaToTareaLocalizacionSeccionPresenciaDto(
            tareaLocalizacionSeccionPresenciaRepository.save(
                mapper.presenciasTotalizadoResponseDtoToTareaLocalizacionSeccionPresencia(dto, tarea)));
    }
}
