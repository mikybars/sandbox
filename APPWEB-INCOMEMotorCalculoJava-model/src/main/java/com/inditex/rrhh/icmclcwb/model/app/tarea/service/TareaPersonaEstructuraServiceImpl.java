package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

@Service
@Validated
public class TareaPersonaEstructuraServiceImpl implements TareaPersonaEstructuraService {

    @Autowired
    private TareaPersonaEstructuraRepository tareaPersonaEstructuraRepository;

    @Autowired
    private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;

    @Autowired
    private TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper;

    @Override
    public List<Long> findIdTipoCalculoByIdTarea(@Valid final Long idTarea) {
        return tareaPersonaEstructuraRepository.findIdTipoCalculoByIdTarea(idTarea);
    }

    @Override
    public List<TareaPersonaEstructuraDto> save(final List<TareaPersonaEstructuraDto> tareaEmpleadoEstructura,
            @Valid final TareaDto tarea) {
        return tareaPersonaEstructuraMapper.tareaPersonaEstructuraToTareaPersonaEstructuraDto(
                tareaPersonaEstructuraRepositoryCustom.save(tareaPersonaEstructuraMapper
                        .mergeTareaPersonaEstructuraDtoAndTareaDtoToTareaPersonaEstructura(tareaEmpleadoEstructura,
                                tarea)));
    }

    @Override
    public List<TareaPersonaEstructuraDto> saveComisionEmpleadoResultItemDto(
            @Valid final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        return save(tareaPersonaEstructuraMapper
                .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraDto(comisionEmpleadoResultItemDto), tarea);
    }

}
