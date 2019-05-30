package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionComisionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionComisionHistoricoRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionComisionHistoricoServiceImpl implements TareaLocalizacionComisionHistoricoService {

    @Autowired
    private TareaLocalizacionComisionHistoricoMapper mapper;
    
    @Autowired
    private TareaLocalizacionComisionHistoricoRepositoryCustom tareaLocalizacionComisionHistoricoRepositoryCustom; 
 
    
    @Override
    public List<TareaLocalizacionComisionHistoricoDto> save(@Valid final List<TareaLocalizacionComisionHistoricoDto> tareaTiendaHistorico,
            @Valid final TareaDto tarea) {
        List<TareaLocalizacionComisionHistoricoDto> result = new ArrayList<>();
        List<TareaLocalizacionComisionHistorico> data = mapper
                .mergeTareaLocalizacionComisionHistoricoDtoAndTareaDtoToTareaLocalizacionComisionHistorico(tareaTiendaHistorico, tarea);
        if (CollectionUtils.isNotEmpty(data)) {
            result.addAll(mapper
                    .tareaLocalizacionComisionHistoricoToTareaLocalizacionComisionHistoricoDto(tareaLocalizacionComisionHistoricoRepositoryCustom.save(data)));
        }
        return result;
    }

    @Override
    public List<TareaLocalizacionComisionHistoricoDto> saveGenericTiendaResultItemDto(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea) {
        return save(mapper
                .genericLocalizacionResultItemDtoToTareaLocalizacionComisionHistoricoDto(genericTiendaResultItemDto), tarea);
    }
}
