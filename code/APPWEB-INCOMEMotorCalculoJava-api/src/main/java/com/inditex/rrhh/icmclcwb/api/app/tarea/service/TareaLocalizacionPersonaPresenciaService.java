package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public interface TareaLocalizacionPersonaPresenciaService {

  void save(@Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto);

  void savePtrPresenciaDetalle(@Valid @NotNull @NotEmpty final List<PtrPresenciaDetalleResultItemDto> src,
      @Valid @NotNull final TareaDto tareaDto, @Valid @NotNull final Integer idTipoDato);

  void updateActivo(@Valid @NotNull final RunTareaDto tareaDto);

  void updateActivoVacio(@Valid @NotNull final RunTareaDto runTareaDto);

  void compensar(@Valid @NotNull final RunTareaDto runTareaDto);

  void presenciasIncluidoVenta(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorPresencia(@Valid @NotNull final RunTareaDto runTareaDto);

  void presenciaDesplazamiento(@Valid @NotNull RunTareaDto runTareaDto);

  void presenciaDesplazamientoChallengePorcentaje(@Valid @NotNull RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamiento(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBase(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
      @Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacionChallengePorcentaje(
      @Valid @NotNull final RunTareaDto runTareaDto);

  void presenciasHorasFijas(@Valid @NotNull final RunTareaDto runTareaDto);

  void presenciasHorasFijasDesplazamientos(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorPersonaPorVenta(@Valid @NotNull final RunTareaDto runTareaDto);

  void compensarChallenge(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVenta(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVenta(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVentaSinPresencias(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@Valid @NotNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVentaCambioFuncion(@Valid @NotNull final RunTareaDto runTareaDto);

  void updateActivoPersonasExternas(@Valid @NotNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoChallengeImporteTienda(@Valid @NotNull final RunTareaDto runTareaDto);

}
