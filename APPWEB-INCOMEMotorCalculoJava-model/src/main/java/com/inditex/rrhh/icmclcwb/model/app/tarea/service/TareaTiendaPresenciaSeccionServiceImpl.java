package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaPresenciaSeccionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaPresenciaSeccionRepositoryCustom;

@Service
@Validated
public class TareaTiendaPresenciaSeccionServiceImpl implements TareaTiendaPresenciaSeccionService {

    @Autowired
    private TareaTiendaPresenciaSeccionMapper mapper;

    @Autowired
    private TareaTiendaPresenciaSeccionRepositoryCustom tareaTiendaPresenciaSeccionRepositoryCustom;

    @Override
    public List<TareaTiendaPresenciaSeccionDto> save(@Valid final List<PtrPresenciaTotalizadoResultItemDto> dto,
            @Valid final TareaDto tarea) {
        return mapper
                .tareaTiendaPresenciaSeccionToTareaTiendaPresenciaSeccionDto(tareaTiendaPresenciaSeccionRepositoryCustom
                        .save(mapper.presenciasTotalizadoResponseDtoToTareaTiendaPresenciaSeccion(dto, tarea)));
    }

    @Override
    public void compensar(@Valid final RunTareaDto runTarea) {
        tareaTiendaPresenciaSeccionRepositoryCustom.compensar(runTarea);
    }
    
    @Override
    public void updateActivo(@Valid final RunTareaDto runTarea) {
        tareaTiendaPresenciaSeccionRepositoryCustom.updateActivo(runTarea);
    }
}
