package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaSeccionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaSeccionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaSeccionPresenciaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaTiendaSeccionPresenciaServiceImpl implements TareaTiendaSeccionPresenciaService {

    @Autowired
    private TareaTiendaSeccionPresenciaMapper mapper;

    @Autowired
    private TareaTiendaSeccionPresenciaRepositoryCustom tareaTiendaSeccionPresenciaRepository;

    @Override
    public List<TareaTiendaSeccionPresenciaDto> save(@Valid List<PtrPresenciaTotalizadoResultItemDto> dto, @Valid TareaDto tarea) {
        return mapper.tareaTiendaSeccionPresenciaToTareaTiendaSeccionPresenciaDto(
            tareaTiendaSeccionPresenciaRepository.save(
                mapper.presenciasTotalizadoResponseDtoToTareaTiendaSeccionPresencia(dto, tarea)));
    }
}
