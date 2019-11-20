package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

@Service
@Validated
public class TareaPersonaEstructuraServiceImpl implements TareaPersonaEstructuraService {

    @Autowired
    private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

    @Autowired
    private TareaPersonaEstructuraDesplazamientoRepositoryCustom tareaPersonaEstructuraDesplazamientoRepositoryCustom;

    @Autowired
    private TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper;

    @Override
    public List<TareaPersonaEstructuraDto> save(@Valid List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
            @Valid TareaDto tarea) {
        // Guardado de estructuras
        List<TareaPersonaEstructuraDto> result = tareaPersonaEstructuraMapper.tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            tareaPersonaEstructuraRepositoryCustom.save(tareaPersonaEstructuraMapper
                .tareaPersonaEstructuraDtoToTareaPersonaEstructura(tareaPersonaEstructura)));
        // Guardado de desplazamientos
        tareaPersonaEstructuraDesplazamientoRepositoryCustom.save(tareaPersonaEstructuraMapper
                .tareaPersonaEstructuraDtoToTareaPersonaEstructuraDesplazamiento(tareaPersonaEstructura));
        return result;
    }

    
    @Override
    public List<TareaPersonaEstructuraDto> mergeEstructurasComResultItemDto(
            @Valid final List<EstructurasComResultItemDto> estructurasComResultItemDto, @Valid final TareaDto tarea) {
        return tareaPersonaEstructuraMapper
                .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(estructurasComResultItemDto, tarea);
    }

}
