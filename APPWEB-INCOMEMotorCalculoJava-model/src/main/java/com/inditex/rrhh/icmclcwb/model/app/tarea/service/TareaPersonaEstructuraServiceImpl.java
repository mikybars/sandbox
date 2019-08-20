package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

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
                .tareaPersonaEstructuraDtoToTareapersonaDesplazamiento(tareaPersonaEstructura));
        return result;
    }

    @Override
    public List<TareaPersonaEstructuraDto> merge(
            @Valid List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, @Valid TareaDto tarea) {
        return tareaPersonaEstructuraMapper
                .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(comisionEmpleadoResultItemDto, tarea);
    }

}
