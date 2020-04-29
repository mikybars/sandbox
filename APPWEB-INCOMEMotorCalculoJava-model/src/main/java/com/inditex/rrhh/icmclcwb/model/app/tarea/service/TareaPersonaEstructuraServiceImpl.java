package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraDesplazamientoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;
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
    
    @Autowired
    private TareaPersonaEstructuraDesplazamientoMapper tareaPersonaEstructuraDesplazamientoMapper;

    @Override
    public List<TareaPersonaEstructuraDto> save(@Valid @NotNull @NotEmpty final List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
            @Valid @NotNull final TareaDto tarea) {
        // Guardado de estructuras
        List<TareaPersonaEstructuraDto> result = tareaPersonaEstructuraMapper.tareaPersonaEstructuraToTareaPersonaEstructuraDto(
            tareaPersonaEstructuraRepositoryCustom.save(tareaPersonaEstructuraMapper
                .tareaPersonaEstructuraDtoToTareaPersonaEstructura(tareaPersonaEstructura)));
        // Guardado de desplazamientos
        List<TareaPersonaEstructuraDesplazamiento> desplazamientos = new ArrayList<TareaPersonaEstructuraDesplazamiento>();
        tareaPersonaEstructura.stream().forEach(item -> {
            if (item.getEstructuraDesplazamiento() != null) {
                desplazamientos.add(tareaPersonaEstructuraDesplazamientoMapper.tareaPersonaEstructuraDesplazamientoDtoToTareaPersonaEstructuraDesplazamiento(item.getEstructuraDesplazamiento()));
            }
        });
        if (CollectionUtils.isNotEmpty(desplazamientos)) { 
            tareaPersonaEstructuraDesplazamientoRepositoryCustom.save(desplazamientos);
        }
        return result;
    }

    
    @Override
    public List<TareaPersonaEstructuraDto> mergeEstructurasComResultItemDto(
            @Valid @NotNull @NotEmpty final List<EstructurasComResultItemDto> estructurasComResultItemDto, @Valid @NotNull final TareaDto tarea) {
        return tareaPersonaEstructuraMapper
            .estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(estructurasComResultItemDto, tarea);
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.id_persona_local_challenge_by_tarea", key = "{#tarea}")
    public List<IdPersonaLocalDto> findPersonasChallenge(@Valid @NotNull final TareaDto tarea) {
        return tareaPersonaEstructuraRepositoryCustom.findPersonasChallenge(tarea);
    }
}
