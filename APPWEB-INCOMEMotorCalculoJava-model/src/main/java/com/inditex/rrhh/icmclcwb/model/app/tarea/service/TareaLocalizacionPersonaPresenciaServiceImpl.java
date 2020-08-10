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
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

@Service
@Validated
public class TareaLocalizacionPersonaPresenciaServiceImpl implements TareaLocalizacionPersonaPresenciaService {

    @Autowired
    private TareaLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;

    @Autowired
    private TareaLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;

    @Override
    public void save(@Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> src,
            @Valid @NotNull final TareaDto tareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.save(this.tareaLocalizacionPersonaPresenciaMapper
            .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
    }

    @Override
    public void savePtrPresenciaDetalle(@Valid @NotNull @NotEmpty final List<PtrPresenciaDetalleResultItemDto> src,
            @Valid @NotNull final TareaDto tareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.save(this.tareaLocalizacionPersonaPresenciaMapper
            .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
    }

    @Override
    public void updateActivo(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo(runTareaDto);
    }

    @Override
    public void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
    }

    @Override
    public void compensar(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.compensar(runTareaDto);
    }

    @Override
    public void compensarChallenge(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.compensarChallenge(runTareaDto);
    }

    @Override
    public void presenciasIncluidoVenta(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasIncluidoVenta(runTareaDto);
    }

    @Override
    public void indicadorPresencia(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresencia(runTareaDto);
    }

    @Override
    public void indicadorPresenciaDesplazamiento(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamiento(runTareaDto);
    }

    @Override
    public void indicadorPresenciaDesplazamientoBase(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamientoBase(runTareaDto);
    }

    @Override
    public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
            @Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTareaDto);
    }

    @Override
    public void presenciasHorasFijas(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijas(runTareaDto);
    }

    @Override
    public void presenciasHorasFijasDesplazamientos(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijasDesplazamiento(runTareaDto);
    }

    @Override
    public void indicadorPersonaPorVenta(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVenta(runTareaDto);
    }

    @Override
    public void indicadorPersonaPorVentaSimplificada(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVentaSimplificada(runTareaDto);
    }

    @Override
    public void indicadorDesplazamientoDirectoVenta(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoDirectoVenta(runTareaDto);
    }

    @Override
    public void indicadorDesplazamientoBaseDirectoVenta(@Valid @NotNull final RunTareaDto runTareaDto) {
        this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorDesplazamientoBaseDirectoVenta(runTareaDto);
    }

}
