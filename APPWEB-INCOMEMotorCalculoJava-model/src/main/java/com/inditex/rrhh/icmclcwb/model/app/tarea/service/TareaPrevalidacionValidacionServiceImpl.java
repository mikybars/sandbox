/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPrevalidacionValidacionService;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confprevalid.ConfPreValidResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeSessionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPrevalidacionValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionValidacionRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPrevalidacionValidacionRepositoryCustom;

@Validated
@Service
public class TareaPrevalidacionValidacionServiceImpl implements TareaPrevalidacionValidacionService {

    @Autowired
    Meta4IcmWsCalcIncomeSessionService meta4IcmWsCalcIncomeSessionService;

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Autowired
    private TareaPrevalidacionValidacionRepository tareaPrevalidacionValidacionRepository;

    @Autowired
    private TareaPrevalidacionValidacionRepositoryCustom tareaPrevalidacionValidacionRepositoryCustom;

    @Autowired
    private TareaPrevalidacionValidacionMapper tareaPrevalidacionValidacionMapper;

    @Override
    public void save(@Valid @NotNull final TareaPrevalidacionValidacionDto src,
            @Valid @NotNull final TareaDto tarea) {
        final TareaPrevalidacionValidacion flujo = this.tareaPrevalidacionValidacionMapper
            .tareaPrevalidacionValidacionDtotoTareaPrevalidacionValidacion(src, tarea);
        this.tareaPrevalidacionValidacionRepository.save(flujo);
    }

    @Override
    public void saveConfPreValidResultItemDto(@Valid @NotNull final List<ConfPreValidResultItemDto> src,
            @Valid @NotNull final TareaPrevalidacionDto tareaPrevalidacionDto) {
        this.tareaPrevalidacionValidacionRepositoryCustom.save(this.tareaPrevalidacionValidacionMapper
            .tareaPrevalidacionValidacionDtoToTareaPrevalidacionValidacion(this.tareaPrevalidacionValidacionMapper
                .confPreValidResultItemDtotoTareaPrevalidacionValidacionDto(src, tareaPrevalidacionDto)));
    }

    @Override
    public TareaPrevalidacionValidacionDto findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(
            @NotNull final Long idTarea,
            @NotNull final Integer idTareaPrevalidacion,
            @NotNull final Integer idTipoValidacion) {
        return this.tareaPrevalidacionValidacionRepositoryCustom
            .findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(idTarea, idTareaPrevalidacion, idTipoValidacion);
    }

    @Override
    public void update(final TareaPrevalidacionValidacionDto tareaPrevalidacionValidacionDto,
            @Valid @NotNull final TareaDto tarea,
            final Integer idEstadoValidacion) {
        this.tareaPrevalidacionValidacionRepositoryCustom.update(idEstadoValidacion,
                tareaPrevalidacionValidacionDto.getIdTareaPrevalidacion(),
                tareaPrevalidacionValidacionDto.getIdTipoValidacion(), tarea.getId());
    }

}
