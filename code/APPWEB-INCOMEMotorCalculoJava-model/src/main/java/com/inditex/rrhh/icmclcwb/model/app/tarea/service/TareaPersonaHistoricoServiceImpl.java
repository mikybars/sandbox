package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHIstoricoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaHistoricoRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaPersonaHistoricoServiceImpl implements TareaPersonaHistoricoService {

  @Autowired
  private TareaPersonaHistoricoRepositoryCustom tareaPersonaHistoricoRepositoryCustom;

  @Autowired
  private TareaPersonaHistoricoMapper tareaPersonaHistoricoMapper;

  @Autowired
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Override
  public List<TareaPersonaHistoricoDto> save(
      @Valid @NotNull @NotEmpty final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico) {
    return this.tareaPersonaHistoricoMapper
        .tareaPersonaHistoricoToTareaPersonaHistoricoDto(
            this.tareaPersonaHistoricoRepositoryCustom.save(this.tareaPersonaHistoricoMapper
                .tareaPersonaHistoricoDtoToTareaPersonaHistorico(tareaEmpleadoHistorico)));
  }

  @Override
  public List<TareaPersonaHistoricoDto> merge(
      @Valid @NotNull @NotEmpty final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto,
      @Valid @NotNull final TareaDto tarea) {
    return this.tareaPersonaHistoricoMapper
        .genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(genericEmpleadoResultItemDto, tarea);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_persona_historico_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(
      @NotNull final Long idTarea,
      @NotNull final String cclIdOrigen) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        cclIdOrigen);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  @Cacheable(value = "itx.icmlcwb.id_persona_historico_by_tarea_and_id_origen_and_tipo_dato",
      key = "{#idTarea, #cclIdOrigen, #idsTipoDato}")
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NotNull final Long idTarea,
      @NotNull final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato) {
    final List<IdPersonaHistoricoDto> personas;
    try {
      this.primaryTemporaryTableRepositoryCustom.createTempAlgoritmo();
      this.primaryTemporaryTableRepositoryCustom.indexTempAlgoritmo();
      this.primaryTemporaryTableRepositoryCustom.insertTempAlgoritmo(
          this.tareaPersonaHistoricoRepositoryCustom
              .findIdTipoCalculoAndIdTipoComisionByIdsTiposDato(idsTipoDato));
      personas = this.tareaPersonaHistoricoRepositoryCustom
          .findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(idTarea, cclIdOrigen, idsTipoDato);
    } finally {
      this.primaryTemporaryTableRepositoryCustom.deleteTempAlgoritmo();
    }
    return personas;
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.periodo_by_tarea", key = "{#idTarea}")
  public PeriodoDto findPeriodoByIdTareaDto(@NotNull final Long idTarea) {
    return this.tareaPersonaHistoricoRepositoryCustom.findPeriodoDtoByIdTarea(idTarea);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_persona_historico_grupo_fechas_by_tarea", key = "{#idTarea}")
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NotNull final Long idTarea) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoGrupoFechasByIdTarea(idTarea);
  }

  @Override
  public List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(
      @NotNull final Long idTarea) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaLocalCompensacionChallengeByIdTarea(idTarea);
  }

  @Override
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NotNull final Long idTarea, @NotNull final String cclIdOrigen) {
    return this.tareaPersonaHistoricoRepositoryCustom
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(idTarea, cclIdOrigen,
            TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS);
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.id_persona_historico_localizacion_by_tarea_and_id_origen", key = "{#idTarea, #cclIdOrigen}")
  public List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NotNull final Long idTarea,
      @NotNull final String cclIdOrigen) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        cclIdOrigen);
  }

}
