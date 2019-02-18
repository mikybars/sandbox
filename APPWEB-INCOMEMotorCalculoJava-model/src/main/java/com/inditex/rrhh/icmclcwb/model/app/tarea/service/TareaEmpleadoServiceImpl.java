package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaEmpleadoRepository;

@Service
@Validated
public class TareaEmpleadoServiceImpl implements TareaEmpleadoService {

    @Autowired
    private TareaEmpleadoRepository tareaEmpleadoRepository;

    @Autowired
    private TareaEmpleadoMapper tareaEmpleadoMapper;

    @Override
    public List<TareaEmpleadoDto> findByTarea(@Valid TareaDto tarea) {
        return tareaEmpleadoMapper
                .tareaEmpleadoToTareaEmpleadoDto(tareaEmpleadoRepository.findByTareaId(tarea.getId()));
    }

    @Override
    public List<TareaEmpleadoDto> createTareaEmpleado(@Valid TareaDto tarea,
            List<TareaEmpleadoDto> tareaEmpleado) {
        return tareaEmpleadoMapper.tareaEmpleadoToTareaEmpleadoDto(tareaEmpleadoRepository.saveAll(
                tareaEmpleadoMapper.mergeTareaEmpleadoDtoAndTareaDtoToTareaEmpleado(tareaEmpleado, tarea)));
    }

}