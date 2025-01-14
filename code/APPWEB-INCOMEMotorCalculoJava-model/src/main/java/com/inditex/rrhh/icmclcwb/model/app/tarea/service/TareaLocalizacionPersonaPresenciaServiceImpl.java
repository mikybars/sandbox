package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaPresenciaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaPresenciaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionPersonaPresenciaServiceImpl implements TareaLocalizacionPersonaPresenciaService {

  @Autowired
  private TareaLocalizacionPersonaPresenciaRepositoryCustom tareaLocalizacionPersonaPresenciaRepositoryCustom;

  @Autowired
  private TareaLocalizacionPersonaPresenciaMapper tareaLocalizacionPersonaPresenciaMapper;

  @Override
  public void save(@Valid @NonNull @NotEmpty final List<GenericEmpleadoResultItemDto> src,
      @Valid @NonNull final TareaDto tareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.save(this.tareaLocalizacionPersonaPresenciaMapper
        .genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(src, tareaDto));
  }

  @Override
  public void savePtrPresenciaDetalle(@Valid @NonNull @NotEmpty final List<PtrPresenciaDetalleResultItemDto> src,
      @Valid @NonNull final TareaDto tareaDto, @Valid @NonNull final Integer idTipoDato) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.save(this.tareaLocalizacionPersonaPresenciaMapper
        .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(src, tareaDto, idTipoDato));
  }

  @Override
  public void updateActivo(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivo(runTareaDto);
  }

  @Override
  public void updateActivoVacio(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoVacio(runTareaDto);
  }

  @Override
  public void compensar(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.compensar(runTareaDto);
  }

  @Override
  public void compensarChallenge(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.compensarChallenge(runTareaDto);
  }

  @Override
  public void presenciasIncluidoVenta(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasIncluidoVenta(runTareaDto);
  }

  @Override
  public void indicadorPresencia(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresencia(runTareaDto);
  }

  @Override
  public void presenciaDesplazamiento(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciaDesplazamiento(runTareaDto);
  }

  @Override
  public void presenciaDesplazamientoChallengePorcentaje(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciaDesplazamientoChallengePorcentaje(runTareaDto);
  }

  @Override
  public void indicadorPresenciaDesplazamiento(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamiento(runTareaDto);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBase(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPresenciaDesplazamientoBase(runTareaDto);
  }

  @Override
  public void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
      @Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTareaDto);
  }

  @Override
  public void presenciasHorasFijas(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijas(runTareaDto);
  }

  @Override
  public void presenciasHorasFijasDesplazamientos(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.presenciasHorasFijasDesplazamiento(runTareaDto);
  }

  @Override
  public void indicadorPersonaPorVenta(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.indicadorPersonaPorVenta(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoDirectoVenta(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoDirectoVenta(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoDirectoVentaSinPresencias(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoDirectoVentaSinPresencias(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVenta(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoBaseDirectoVenta(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoBaseDirectoVentaOtraTienda(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoBaseDirectoVentaOtraTienda(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoDirectoVentaCambioFuncion(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoDirectoVentaCambioFuncion(runTareaDto);
  }

  @Override
  public void indicadorDesplazamientoChallengeImporteTienda(@Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom
        .indicadorDesplazamientoChallengeImporteTienda(runTareaDto);
  }

  @Override
  public void updateActivoPersonasExternas(
      @Valid @NonNull final RunTareaDto runTareaDto) {
    this.tareaLocalizacionPersonaPresenciaRepositoryCustom.updateActivoPersonasExternas(runTareaDto);
  }

}
