package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoSeccionEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoSeccionEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoSeccionEstructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class TareaEmpleadoSeccionEstructuraServiceImpl implements TareaEmpleadoSeccionEstructuraService {

    @Autowired
    private TareaEmpleadoSeccionEstructuraRepository tareaEmpleadoSeccionEstructuraRepository;
    
    @Autowired
    private TareaEmpleadoSeccionEstructuraMapper tareaEmpleadoSeccionEstructuraMapper;
    
    @Override
    public List<TareaEmpleadoSeccionEstructuraDto> save(List<TareaEmpleadoSeccionEstructuraDto> tareaEmpleadoSeccionEstructura,
            @Valid TareaDto tarea) {
        return tareaEmpleadoSeccionEstructuraMapper.tareaEmpleadoSeccionEstructuraToTareaEmpleadoSeccionEstructuraDto(
                tareaEmpleadoSeccionEstructuraRepository.saveAll(tareaEmpleadoSeccionEstructuraMapper
                        .tareaEmpleadoSeccionEstructuraDtoToTareaEmpleadoSeccionEstructura(tareaEmpleadoSeccionEstructura)));
    }

    @Override
    public List<TareaEmpleadoSeccionEstructuraDto> saveComisionEmpleadoResultItemDto(
        @Valid List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, @Valid TareaDto tarea) {
        return save(
            tareaEmpleadoSeccionEstructuraMapper.comisionEmpleadoResultItemDtoToTareaEmpleadoSeccionEstructuraDto(comisionEmpleadoResultItemDto, tarea),
            tarea);
    }

}
