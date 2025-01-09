package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPersonaPresenciaService {

  void save(@Valid @NonNull @NotEmpty final List<GenericEmpleadoResultItemDto> src,
      @Valid @NonNull final TareaDto tareaDto);

  void savePtrPresenciaDetalle(@Valid @NonNull @NotEmpty final List<PtrPresenciaDetalleResultItemDto> src,
      @Valid @NonNull final TareaDto tareaDto, @Valid @NonNull final Integer idTipoDato);

  void updateActivo(@Valid @NonNull final RunTareaDto tareaDto);

  void updateActivoVacio(@Valid @NonNull final RunTareaDto runTareaDto);

  void compensar(@Valid @NonNull final RunTareaDto runTareaDto);

  void presenciasIncluidoVenta(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorPresencia(@Valid @NonNull final RunTareaDto runTareaDto);

  void presenciaDesplazamiento(@Valid @NonNull RunTareaDto runTareaDto);

  void presenciaDesplazamientoChallengePorcentaje(@Valid @NonNull RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamiento(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBase(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
      @Valid @NonNull final RunTareaDto runTareaDto);

  void presenciasHorasFijas(@Valid @NonNull final RunTareaDto runTareaDto);

  void presenciasHorasFijasDesplazamientos(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorPersonaPorVenta(@Valid @NonNull final RunTareaDto runTareaDto);

  void compensarChallenge(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVenta(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVenta(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVentaSinPresencias(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@Valid @NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVentaCambioFuncion(@Valid @NonNull final RunTareaDto runTareaDto);

  void updateActivoPersonasExternas(@Valid @NonNull final RunTareaDto runTareaDto);

  void indicadorDesplazamientoChallengeImporteTienda(@Valid @NonNull final RunTareaDto runTareaDto);

}
