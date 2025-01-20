package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_PERSONA_HISTORICO_BY_TAREA_AND_ID_ORIGEN;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_PERSONA_HISTORICO_BY_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_PERSONA_HISTORICO_GRUPO_FECHAS_BY_TAREA;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.ID_PERSONA_HISTORICO_LOCALIZACION_BY_TAREA_AND_ID_ORIGEN;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.PERIODO_BY_TAREA;

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
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.jspecify.annotations.NonNull;
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
      @Valid @NonNull @NotEmpty final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico) {
    return this.tareaPersonaHistoricoMapper
        .tareaPersonaHistoricoToTareaPersonaHistoricoDto(
            this.tareaPersonaHistoricoRepositoryCustom.save(this.tareaPersonaHistoricoMapper
                .tareaPersonaHistoricoDtoToTareaPersonaHistorico(tareaEmpleadoHistorico)));
  }

  @Override
  public List<TareaPersonaHistoricoDto> merge(
      @Valid @NonNull @NotEmpty final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto,
      @Valid @NonNull final TareaDto tarea) {
    return this.tareaPersonaHistoricoMapper
        .genericEmpleadoResultItemDtoToTareaPersonaHistoricoDto(genericEmpleadoResultItemDto, tarea);
  }

  @Override
  public List<TareaPersonaHistoricoDto> mergeEmpleadoDtos(
      @Valid @NonNull @NotEmpty final List<EmpleadoDTO> empleadoDTOList,
      @Valid @NonNull final TareaDto tarea) {
    return this.tareaPersonaHistoricoMapper
        .empleadoDtoToTareaPersonaHistoricoDto(empleadoDTOList, tarea);
  }

  @Override
  @Cacheable(value = ID_PERSONA_HISTORICO_BY_TAREA_AND_ID_ORIGEN, key = "{#idTarea, #cclIdOrigen}")
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(
      @NonNull final Long idTarea,
      @NonNull final String cclIdOrigen) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        cclIdOrigen);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  @Cacheable(value = ID_PERSONA_HISTORICO_BY_TAREA_AND_ID_ORIGEN_AND_TIPO_DATO,
      key = "{#idTarea, #cclIdOrigen, #idsTipoDato}")
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NonNull final Long idTarea,
      @NonNull final String cclIdOrigen, @NonNull final List<Integer> idsTipoDato) {
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
  @Cacheable(value = PERIODO_BY_TAREA, key = "{#idTarea}")
  public PeriodoDto findPeriodoByIdTareaDto(@NonNull final Long idTarea) {
    return this.tareaPersonaHistoricoRepositoryCustom.findPeriodoDtoByIdTarea(idTarea);
  }

  @Override
  @Cacheable(value = ID_PERSONA_HISTORICO_GRUPO_FECHAS_BY_TAREA, key = "{#idTarea}")
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(@NonNull final Long idTarea) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoGrupoFechasByIdTarea(idTarea);
  }

  @Override
  public List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(
      @NonNull final Long idTarea) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaLocalCompensacionChallengeByIdTarea(idTarea);
  }

  @Override
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NonNull final Long idTarea, @NonNull final String cclIdOrigen) {
    return this.tareaPersonaHistoricoRepositoryCustom
        .findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(idTarea, cclIdOrigen,
            TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS);
  }

  @Override
  @Cacheable(value = ID_PERSONA_HISTORICO_LOCALIZACION_BY_TAREA_AND_ID_ORIGEN, key = "{#idTarea, #cclIdOrigen}")
  public List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NonNull final Long idTarea,
      @NonNull final String cclIdOrigen) {
    return this.tareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(idTarea,
        cclIdOrigen);
  }

}
