package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ClientDatabase;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ClientDatabaseContextHolder;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ComisServiceImpl implements ComisService {

  @Autowired
  private ComisRepositoryCustom comisRepositoryCustom;

  @Autowired
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    PresenciaOrigenDto presencia = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      presencia = this.comisRepositoryCustom
          .findPresenciasOrigenAndFecha(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return presencia;
  }

  @Override
  public List<IdMotivoDesplazamientoDto> findMotivoDesplazamiento(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdMotivoDesplazamientoDto> motivos = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      motivos = this.comisRepositoryCustom
          .findMotivoDesplazamiento(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return motivos;
  }

  @Override
  public List<IdPersonaLocalFechaIncidenciaDto> findFechasIncidencias(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalFechaIncidenciaDto> incidencias = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      incidencias = this.comisRepositoryCustom
          .findFechasIncidencias(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return incidencias;
  }

  @Override
  public List<IdPersonaLocalFechaIncidenciaDto> findFechasDesplazamientos(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalFechaIncidenciaDto> desplazamientos = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      desplazamientos = this.comisRepositoryCustom
          .findFechasDesplazamientos(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return desplazamientos;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistorico(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> historico = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      historico = this.comisRepositoryCustom
          .findCondicionesHistorico(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return historico;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> historico = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      historico = this.comisRepositoryCustom
          .findCondicionesHistoricoEs(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return historico;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamiento(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> desplazamiento = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      desplazamiento = this.comisRepositoryCustom
          .findCondicionesDesplazamiento(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return desplazamiento;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> desplazamiento = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      desplazamiento = this.comisRepositoryCustom
          .findCondicionesDesplazamientoEs(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return desplazamiento;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResalta(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> resalta = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      resalta = this.comisRepositoryCustom
          .findCondicionesResalta(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return resalta;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinPrimas(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> resalta = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      resalta = this.comisRepositoryCustom
          .findCondicionesResaltaSinPrimas(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return resalta;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> resalta = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      resalta = this.comisRepositoryCustom
          .findCondicionesResaltaEs(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return resalta;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesPrimas(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> resalta = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      resalta = this.comisRepositoryCustom
          .findCondicionesPrimas(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return resalta;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findBajasIt(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> bajasIt = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      bajasIt = this.comisRepositoryCustom
          .findBajasIt(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return bajasIt;
  }

  @Override
  public List<IdPersonaLocalCarenciaDto> findCarencia(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCarenciaDto> carencia = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      carencia = this.comisRepositoryCustom
          .findCarencia(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return carencia;
  }

  @Override
  public List<IdPersonaLocalExternaDto> findExternosByClase(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      final ComisClaseEmpleadoEnum clase) {
    List<IdPersonaLocalExternaDto> externos = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      externos = this.comisRepositoryCustom.findExternosByClase(runTareaDto.getTarea(), clase);
    } finally {
      ClientDatabaseContextHolder.clear();
    }
    return externos;
  }

  @Override
  public List<IdPersonaLocalExternaDto> findExternosByMinIdPersona(
      @Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito,
      @NotNull @Positive final Long minIdPersona) {
    List<IdPersonaLocalExternaDto> externos = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      externos = this.comisRepositoryCustom.findExternosByMinIdPersona(runTareaDto.getTarea(), minIdPersona);
    } finally {
      ClientDatabaseContextHolder.clear();
    }
    return externos;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findBajasItEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> bajasIt = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      bajasIt = this.comisRepositoryCustom
          .findBajasItEs(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return bajasIt;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoSinChallenge(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> historico = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      historico = this.comisRepositoryCustom
          .findCondicionesHistoricoSinChallenge(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return historico;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoSinChallenge(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> desplazamiento = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      desplazamiento = this.comisRepositoryCustom
          .findCondicionesDesplazamientoSinChallenge(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return desplazamiento;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesResaltaSinChallenge(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> resalta = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      resalta = this.comisRepositoryCustom
          .findCondicionesResaltaSinChallenge(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return resalta;
  }

  @Override
  public List<IdPersonaLocalComisionManualDto> findComisionManual(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito) {
    try {
      this.setContext(runTareaDto, tareaAmbito);
      return this.comisRepositoryCustom.findComisionManual(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonas(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito, @NotNull final Long maxIdPersona) {
    try {
      this.setContext(runTareaDto, tareaAmbito);
      return this.comisRepositoryCustom.findPersonas(runTareaDto.getTarea(), maxIdPersona);
    } finally {
      ClientDatabaseContextHolder.clear();
    }
  }

  @Override
  public List<IdPersonaLocalLocalizacionDto> findPersonasSil(
      @Valid final RunTareaDto runTareaDto, @Valid final TareaAmbitoDto tareaAmbito, @NotNull final Long maxIdPersona,
      @Valid final ClaseResultItemDto clase) {
    List<IdPersonaLocalLocalizacionDto> personas;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      if (CollectionUtils.isNotEmpty(clase.getIdsEstadoSil())) {
        personas = this.comisRepositoryCustom.findPersonasSilConEstado(runTareaDto.getTarea(), maxIdPersona, clase);
      } else {
        personas = this.comisRepositoryCustom.findPersonasSilSinEstado(runTareaDto.getTarea(), maxIdPersona, clase);
      }
    } finally {
      ClientDatabaseContextHolder.clear();
    }
    return personas;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesHistoricoChallengeIncluidoPorcentaje(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> historico = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      historico = this.comisRepositoryCustom
          .findCondicionesHistoricoChallengeIncluidoPorcentaje(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return historico;
  }

  @Override
  public List<IdPersonaLocalCondicionesDto> findCondicionesDesplazamientoChallengeIncluidoPorcentaje(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalCondicionesDto> historico = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      historico = this.comisRepositoryCustom
          .findCondicionesDesplazamientoChallengeIncluidoPorcentaje(runTareaDto.getTarea(),
              this.tareaAmbitoGlobalFechaService.findFechaAmbitoDtoByIdTareaAndIdTipoDato(
                  runTareaDto.getTarea().getId(),
                  TipoDatoEnum.PERIODO_AMPLIADO.getId()));
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return historico;
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisRecuperarFrancia(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    List<IdPersonaLocalDto> personas = null;
    try {
      this.setContext(runTareaDto, tareaAmbito);
      personas = this.comisRepositoryCustom
          .validateTempComisRecuperarFrancia(runTareaDto.getTarea());
    } finally {
      ClientDatabaseContextHolder.clear();
    }

    return personas;
  }

  private void setContext(final RunTareaDto runTareaDto, final TareaAmbitoDto tareaAmbito) {
    if (AppConstants.ID_ORIGEN_SPAIN.equals(tareaAmbito.getCclIdOrigen())) {
      ClientDatabaseContextHolder
          .set(ClientDatabase.getClient(tareaAmbito.getCclIdOrigen()
              + AppConstants.UNDERSCORE
              + runTareaDto.getTarea().getStdIdLegEnt()));
    } else {
      ClientDatabaseContextHolder
          .set(ClientDatabase
              .getClient(tareaAmbito.getCclIdOrigen()));
    }
  }

}
