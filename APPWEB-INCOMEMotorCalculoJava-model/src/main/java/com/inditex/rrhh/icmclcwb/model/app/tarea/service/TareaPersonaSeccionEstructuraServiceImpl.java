package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaSeccionEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaSeccionEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaSeccionEstructuraRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaPersonaSeccionEstructuraServiceImpl implements TareaPersonaSeccionEstructuraService {

    @Autowired
    private TareaPersonaSeccionEstructuraRepositoryCustom tareaPersonaSeccionEstructuraRepositoryCustom;
    
    @Autowired
    private TareaPersonaSeccionEstructuraMapper tareaPersonaSeccionEstructuraMapper;
    
    @Override
    public List<TareaPersonaSeccionEstructuraDto> save(List<TareaPersonaSeccionEstructuraDto> tareaPersonaSeccionEstructura,
            @Valid TareaDto tarea) {
        return tareaPersonaSeccionEstructuraMapper.tareaPersonaSeccionEstructuraToTareaPersonaSeccionEstructuraDto(
                tareaPersonaSeccionEstructuraRepositoryCustom.save(tareaPersonaSeccionEstructuraMapper
                        .tareaPersonaSeccionEstructuraDtoToTareaPersonaSeccionEstructura(tareaPersonaSeccionEstructura)));
    }

    @Override
    public List<TareaPersonaSeccionEstructuraDto> saveComisionEmpleadoResultItemDto(
        @Valid List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, @Valid TareaDto tarea) {
        return save(
            tareaPersonaSeccionEstructuraMapper.comisionEmpleadoResultItemDtoToTareaPersonaSeccionEstructuraDto(comisionEmpleadoResultItemDto, tarea),
            tarea);
    }

}
