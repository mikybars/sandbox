package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionHistoricoRepositoryCustom;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaLocalizacionHistoricoServiceImpl implements TareaLocalizacionHistoricoService {

  @Autowired
  private TareaLocalizacionHistoricoRepository tareaLocalizacionHistoricoRepository;

  @Autowired
  private TareaLocalizacionHistoricoRepositoryCustom tareaLocalizacionHistoricoRepositoryCustom;

  @Autowired
  private TareaLocalizacionHistoricoMapper tareaLocalizacionHistoricoMapper;

  @Override
  public List<TareaLocalizacionHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico) {
    return this.tareaLocalizacionHistoricoMapper.tareaLocalizacionHistoricoToTareaLocalizacionHistoricoDto(
        this.tareaLocalizacionHistoricoRepositoryCustom.save(this.tareaLocalizacionHistoricoMapper
            .tareaLocalizacionHistoricoDtoToTareaLocalizacionHistorico(tareaLocalizacionHistorico)));
  }

  @Override
  public List<TareaLocalizacionHistoricoDto> merge(
      @Valid @NotNull @NotEmpty final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaLocalizacionHistoricoMapper
        .genericLocalizacionResultItemDtoToTareaLocalizacionHistoricoDto(genericTiendaResultItemDto, tarea);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_by_tarea_and_id_origen_in_ambito", key = "{#idTarea, #cclIdOrigen}")
  public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen) {
    return this.tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
        idTarea,
        cclIdOrigen);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_id_cadena",
      key = "{#idTarea, #cclIdOrigen, #idsCadena}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(
      @NotNull final Long idTarea, @NotBlank final String cclIdOrigen, @NotNull final List<String> idsCadena) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(idTarea, cclIdOrigen, idsCadena);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_in_ambito",
      key = "{#idTarea, #cclIdOrigen}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
      @NotNull final Long idTarea, @NotBlank final String cclIdOrigen) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(idTarea, cclIdOrigen);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_id_empresa_in_ambito",
      key = "{#idTarea, #cclIdOrigen, #stdIdLegEnt}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(idTarea, cclIdOrigen, stdIdLegEnt);
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(idTarea,
            cclIdOrigen, stdIdLegEnt);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_by_tarea_and_id_origen_and_id_empresa_in_ambito",
      key = "{#idTarea, #cclIdOrigen, #stdIdLegEnt}")
  public List<IdLocalizacionEmpresaDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(idTarea, cclIdOrigen, stdIdLegEnt);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen) {
    return this.tareaLocalizacionHistoricoRepository.findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(idTarea,
        cclIdOrigen);
  }

  @Override
  public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen,
      @NotNull final Long idVentaConcepto) {
    return this.findIdCadenaDtoByIdTareaAndCclIdOrigen(idTarea, cclIdOrigen,
        Collections.singletonList(idVentaConcepto));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen_and_tipo_dato",
      key = "{#idTarea, #cclIdOrigen, #idVentaConcepto}")
  public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(
      @NotNull final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull final List<Long> idVentaConcepto) {
    return this.tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, cclIdOrigen,
        idVentaConcepto);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
  public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigen(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen) {
    return this.tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen(idTarea, cclIdOrigen);
  }

  @Override
  public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(@NotNull final Long idTarea,
      @NotBlank final String cclIdOrigen, @NotBlank final String stdIdLegEnt, @NotNull final Long idVentaConcepto) {

    return this.tareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigenAndEmpresa(idTarea, cclIdOrigen,
        stdIdLegEnt, Collections.singletonList(idVentaConcepto));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_cadena_by_tarea_and_id_origen_and_tipo_dato_not_in_ambito",
      key = "{#idTarea, #cclIdOrigen, #idVentaConcepto}")
  public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(
      @NotNull final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull final List<Long> idVentaConcepto) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(idTarea,
            cclIdOrigen,
            idVentaConcepto);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_id_tipo_calculo",
      key = "{#idTarea, #cclCodOrigen, #idTipoCalculo}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NotNull final List<String> idTipoCalculo) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(idTarea, cclCodOrigen,
            idTipoCalculo);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_id_empresa_and_id_tipo_calculo",
      key = "{#idTarea, #cclCodOrigen, #stdIdLegEnt, #idTipoCalculo}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt,
      @NotNull final List<String> idTipoCalculo) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(idTarea,
            cclCodOrigen,
            stdIdLegEnt, idTipoCalculo);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_presupuestos_by_tarea", key = "{#idTarea}")
  public List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByIdTarea(
      @NotNull @Positive final Long idTarea) {
    return this.tareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoPresupuestosByIdTarea(idTarea);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_presupuestos_by_id_empresa_and_id_tarea",
      key = "{#stdIdLegEnt, #idTarea, #idTipoConceptoVentaChallenge}")
  public List<IdLocalizacionLocalPresupuestoDto> findTiendasPresupuestosByStdIdLegEntAndIdTarea(
      @NotNull @NotEmpty final List<String> stdIdLegEnt, @NotNull @Positive final Long idTarea,
      @NotNull @NotEmpty final List<Long> idTipoConceptoVentaChallenge) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea(stdIdLegEnt, idTarea, idTipoConceptoVentaChallenge);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_id_empresa",
      key = "{#idTarea, #cclIdOrigen, #stdIdLegEnt}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
      @NotNull @Positive final Long idTarea,
      @NotBlank final String cclIdOrigen, @NotBlank final String stdIdLegEnt) {
    return this.tareaLocalizacionHistoricoRepository
        .findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(idTarea,
            cclIdOrigen, stdIdLegEnt);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_tarea_and_id_origen_and_ids_empresa",
      key = "{#idTarea, #cclIdOrigen, #stdIdLegEnt}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    return this.tareaLocalizacionHistoricoRepository
        .findIdLocalizacionLocalDtoByIdTareaAndCClIdOrigenAndStdIdLegEntList(idTarea,
            cclIdOrigen, stdIdLegEnt);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_localizacion_local_by_id_tipo_presupuesto_and_fecha_and_tarea",
      key = "{#idTarea, #idTipoPresupuesto, #fechaInicio, #fechaFin}")
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(
      @NotNull @Positive final Long idTarea,
      @NotNull @Positive final Integer idTipoPresupuesto,
      @NotNull final LocalDate fechaInicio,
      @NotNull final LocalDate fechaFin) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(idTarea, idTipoPresupuesto, fechaInicio,
            fechaFin);
  }

  @Override
  public void mergeLocalizacionFicticia(@NotNull final Long idTarea, @NotNull final String cclIdOrigen,
      @NotBlank final String stdIdLegEnt) {
    this.tareaLocalizacionHistoricoRepositoryCustom
        .mergeLocalizacionFicticia(idTarea, cclIdOrigen, stdIdLegEnt);
  }

  @Override
  public List<IdLocalizacionLocalDto> findLocalizacionFicticiaByIdOrigenAndIdEmpresa(
      @NotNull final String cclIdOrigen,
      @NotBlank final String stdIdLegEnt) {
    return this.tareaLocalizacionHistoricoRepositoryCustom
        .findLocalizacionFicticiaByIdOrigenAndIdEmpresa(cclIdOrigen, stdIdLegEnt);
  }

}
