package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaCalculoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaCalculoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPersonaRepositoryCustom;

@Service
@Validated
public class TareaCalculoPersonaServiceImpl implements TareaCalculoPersonaService {

    @Autowired
    private TareaCalculoPersonaMapper tareaCalculoPersonaMapper;

    @Autowired
    private TareaCalculoPersonaRepository tareaCalculoPersonaRepository;

    @Autowired
    private TareaCalculoPersonaRepositoryCustom tareaCalculoPersonaRepositoryCustom;

    @Override
    public void save(final List<TareaCalculoPersonaDto> personas, final EstadoTareaPersonaDto estado) {
        tareaCalculoPersonaRepositoryCustom.save(tareaCalculoPersonaMapper.tareaCalculoPersonaDtoToTareaCalculoPersona(personas, estado));
    }
    
    @Override
    public void updateWithEstado(final List<TareaCalculoPersonaDto> personas, RunTareaDto runTareaDto , final EstadoTareaPersonaDto estado) {
        tareaCalculoPersonaRepositoryCustom.updateWithEstado(personas.stream().map(e->e.getIdPersona()).collect(Collectors.toList()), runTareaDto, estado);
    }
    
    @Override
    public void mergePersonaCalculo(RunTareaDto runTareaDto) {
        tareaCalculoPersonaRepositoryCustom.mergePersonaCalculo(runTareaDto);
    }

    @Override
    public List<TareaCalculoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
        return tareaCalculoPersonaMapper.tareaCalculoPersonaToTareaCalculoPersonaDto(
                tareaCalculoPersonaRepository.findByTareaId(tarea.getId()));
    }

}
