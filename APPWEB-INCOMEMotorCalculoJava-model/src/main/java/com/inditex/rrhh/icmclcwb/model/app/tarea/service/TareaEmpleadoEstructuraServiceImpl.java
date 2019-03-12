package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoEstructuraRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoEstructuraRepositoryCustom;

@Service
@Validated
public class TareaEmpleadoEstructuraServiceImpl implements TareaEmpleadoEstructuraService {

    @Autowired
    private TareaEmpleadoEstructuraRepository tareaEmpleadoEstructuraRepository;

    @Autowired
    private TareaEmpleadoEstructuraRepositoryCustom tareaEmpleadoEstructuraRepositoryCustom;

    @Autowired
    private TareaEmpleadoEstructuraMapper tareaEmpleadoEstructuraMapper;

    @Override
    public Set<Long> findIdTipoCalculoByIdTarea(@Valid final Long idTarea) {
        return tareaEmpleadoEstructuraRepository.findIdTipoCalculoByIdTarea(idTarea);
    }

    @Override
    public List<TareaEmpleadoEstructuraDto> save(final List<TareaEmpleadoEstructuraDto> tareaEmpleadoEstructura,
            @Valid final TareaDto tarea) {
        return tareaEmpleadoEstructuraMapper.tareaEmpleadoEstructuraToTareaEmpleadoEstructuraDto(
                tareaEmpleadoEstructuraRepositoryCustom.save(tareaEmpleadoEstructuraMapper
                        .mergeTareaEmpleadoEstructuraDtoAndTareaDtoToTareaEmpleadoEstructura(tareaEmpleadoEstructura,
                                tarea)));
    }

    @Override
    public List<TareaEmpleadoEstructuraDto> saveGenericEmpleadoResultItemDto(
            final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        return save(tareaEmpleadoEstructuraMapper
                .genericEmpleadoResultItemDtoToTareaEmpleadoEstructuraDto(genericEmpleadoResultItemDto), tarea);
    }

}
