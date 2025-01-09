package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPersonaPresenciaRepositoryCustom {

  List<TareaLocalizacionPersonaPresencia> save(List<TareaLocalizacionPersonaPresencia> src);

  void updateActivo(@NonNull RunTareaDto runTareaDto);

  void compensar(@NonNull RunTareaDto runTareaDto);

  void presenciasIncluidoVenta(@NonNull RunTareaDto runTareaDto);

  void updateActivoVacio(@NonNull RunTareaDto runTareaDto);

  void indicadorPresencia(@NonNull RunTareaDto runTareaDto);

  void presenciaDesplazamiento(@NonNull RunTareaDto runTareaDto);

  void presenciaDesplazamientoChallengePorcentaje(@NonNull RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamiento(@NonNull RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBase(@NonNull RunTareaDto runTareaDto);

  void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@NonNull RunTareaDto runTareaDto);

  void presenciasHorasFijas(@NonNull RunTareaDto runTareaDto);

  void presenciasHorasFijasDesplazamiento(@NonNull RunTareaDto runTareaDto);

  void indicadorPersonaPorVenta(@NonNull RunTareaDto runTareaDto);

  void compensarChallenge(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVenta(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVenta(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVentaSinPresencias(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoDirectoVentaCambioFuncion(@NonNull RunTareaDto runTareaDto);

  void updateActivoPersonasExternas(@NonNull RunTareaDto runTareaDto);

  void indicadorDesplazamientoChallengeImporteTienda(@NonNull RunTareaDto runTareaDto);

}
