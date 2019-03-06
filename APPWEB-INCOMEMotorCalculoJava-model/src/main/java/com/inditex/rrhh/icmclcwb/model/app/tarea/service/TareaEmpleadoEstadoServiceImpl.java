package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoEstadoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoEstadoRepositoryCustom;

@Service
@Validated
public class TareaEmpleadoEstadoServiceImpl implements TareaEmpleadoEstadoService {

    @Autowired
    private TareaEmpleadoEstadoRepository tareaEmpleadoEstadoRepository;

    @Autowired
    private TareaEmpleadoEstadoRepositoryCustom tareaEmpleadoEstadoRepositoryCustom;

    @Autowired
    private TareaEmpleadoEstadoMapper tareaEmpleadoEstadoMapper;

    @Override
    public List<TareaEmpleadoEstadoDto> save(@Valid final List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado) {
        return tareaEmpleadoEstadoMapper.tareaEmpleadoEstadoToTareaEmpleadoEstadoDto(
                tareaEmpleadoEstadoRepositoryCustom.save(tareaEmpleadoEstadoMapper
                        .tareaEmpleadoEstadoDtoToTareaEmpleadoEstado(tareaEmpleadoEstado)));
    }

    @Override
    public List<TareaEmpleadoEstadoDto> save(@Valid final List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado,
            @Valid final TareaDto tarea) {
        return tareaEmpleadoEstadoMapper
                .tareaEmpleadoEstadoToTareaEmpleadoEstadoDto(tareaEmpleadoEstadoRepositoryCustom.save(
                        tareaEmpleadoEstadoMapper.mergeTareaEmpleadoEstadoDtoAndTareaDtoToTareaEmpleadoEstado(
                                tareaEmpleadoEstado, tarea)));
    }

    @Override
    public List<String> findIdsEmpleadoByIdTareaAndIdEstado(final Long idTarea, final Long idEstado) {
        return tareaEmpleadoEstadoRepository.findIdsEmpleadoByIdTareaAndIdEstado(idTarea, idEstado);
    }

}