package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
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
    public void updateWithEstadoAndidPersona(@Valid @NotNull @NotEmpty final List<IdPersonaLocalDto> personas,
            @Valid @NotNull final RunTareaDto runTareaDto, @Valid @NotNull final EstadoTareaPersonaDto estado) {
        this.tareaCalculoPersonaRepositoryCustom.updateWithEstadoAndidPersona(
                personas.stream().map(e -> e.getIdPersonaLocal()).collect(Collectors.toList()), runTareaDto, estado);
    }

    @Override
    public void updateWithEstado(@Valid @NotNull final RunTareaDto runTareaDto,
            @Valid @NotNull final EstadoTareaPersonaDto estadoActual,
            @Valid @NotNull final EstadoTareaPersonaDto estadoNuevo) {
        this.tareaCalculoPersonaRepositoryCustom.updateWithEstado(runTareaDto, estadoActual, estadoNuevo);
    }

    @Override
    public void mergePersonaCalculoByAmbito(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbito(runTareaDto);
    }

    @Override
    public void mergePersonaCalculoByAmbitoLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoLocalizacion(runTareaDto);
    }

    @Override
    public void mergePersonaCalculoByAmbitoPersona(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoPersona(runTareaDto);
    }

    @Override
    public List<TareaCalculoPersonaDto> findByTarea(@Valid @NotNull final TareaDto tarea) {
        return this.tareaCalculoPersonaMapper.tareaCalculoPersonaToTareaCalculoPersonaDto(
                this.tareaCalculoPersonaRepository.findByTareaId(tarea.getId()));
    }

    @Override
    public List<IdPersonaLocalDto> findByAlgoritmo(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final AlgoritmoDto algoritmo) {
        return this.tareaCalculoPersonaRepositoryCustom.findByAlgoritmo(tarea, algoritmo);
    }

    @Override
    public List<IdPersonaLocalDto> findByTareaAndIdEstadoAndIdTipoPolitica(@Valid @NotNull final TareaDto tarea,
            @Valid @NotNull final String idTipoPolitica) {
        return this.tareaCalculoPersonaRepositoryCustom.findByTareaAndIdEstadoAndIdTipoPolitica(tarea,
                idTipoPolitica);
    }

}
