package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanuallocalizacion.dto.PresenciaManualLocalizacionResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPresenciaServiceImpl implements TareaLocalizacionPresenciaService {

    @Autowired
    private TareaLocalizacionPresenciaRepositoryCustom tareaLocalizacionPresenciaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPresenciaMapper tareaLocalizacionPresenciaMapper;

    @Override
    public void save(@Valid @NotNull @NotEmpty final List<PresenciaManualLocalizacionResultItemDto> src,
            @Valid @NotNull final TareaDto tareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.save(this.tareaLocalizacionPresenciaMapper
            .presenciaManualLocalizacionResultItemDtoToTareaLocalizacionPresencia(src, tareaDto));
    }

    @Override
    public void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
    }

    @Override
    public void compensar(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.compensar(runTareaDto);
    }

    @Override
    public void totalizar(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizar(runTareaDto);
    }

    @Override
    public void totalizarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEcommerce(runTareaDto);
    }

    @Override
    public void compensarEcommerce(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.compensarEcommerce(runTareaDto);
    }

    @Override
    public void totalizarEmpleadosPorVenta(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.totalizarEmpleadosPorVenta(runTareaDto);
    }

    @Override
    public void compensarLocalizacionManual(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPresenciaRepositoryCustom.compensarLocalizacionManual(runTareaDto);
    }

}
