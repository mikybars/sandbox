package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper between COMIS REST client model DTOs and API DTOs.
 */
@Mapper(componentModel = "spring")
public interface ComisClientMapper {

  // -------------------------------------------------------------------------
  // Request mappings: API → client model
  // -------------------------------------------------------------------------

  /**
   * Maps API {@code TareaDto} to the client model {@code TareaDto}, skipping nested list fields that are not needed by the facade API
   * (routing is handled via X-Origin-Id header).
   *
   * @param src the API task DTO.
   * @return the client model task DTO.
   */
  @Mapping(target = "ambito", ignore = true)
  @Mapping(target = "persona", ignore = true)
  @Mapping(target = "localizacion", ignore = true)
  com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaDto toDto(
      com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto src);

  /**
   * Maps API {@code EstadoTareaDto} to the client model {@code EstadoTareaDto}.
   *
   * @param src the API task-state DTO.
   * @return the client model task-state DTO.
   */
  com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.EstadoTareaDto toDto(
      com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto src);

  /**
   * Maps API {@code TareaAmbitoDto} to the client model {@code TareaAmbitoDto}.
   *
   * @param src the API scope DTO.
   * @return the client model scope DTO.
   */
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idTarea", ignore = true)
  com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaAmbitoDto toDto(
      com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto src);

  /**
   * Maps API {@code PeriodoDto} to the client model {@code PeriodoDto}.
   *
   * @param src the API period DTO.
   * @return the client model period DTO.
   */
  @Mapping(target = "id", ignore = true)
  com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PeriodoDto toDto(
      com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto src);

  /**
   * Maps API {@code ClaseResultItemDto} to the client model {@code ClaseResultItemDto}.
   *
   * @param src the API clase DTO.
   * @return the client model clase DTO.
   */
  com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.ClaseResultItemDto toDto(
      com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto src);

  // -------------------------------------------------------------------------
  // Response mappings: client model → API
  // -------------------------------------------------------------------------

  /**
   * Maps client model {@code PresenciaOrigenDto} to the API {@code PresenciaOrigenDto}.
   *
   * @param src the client model DTO.
   * @return the API DTO.
   */
  PresenciaOrigenDto toDto(
      com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto src);

  /**
   * Maps a list of client model {@code IdMotivoDesplazamientoDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdMotivoDesplazamientoDto> toApiMotivoDesplazamientoList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdMotivoDesplazamientoDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalFechaIncidenciaDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalFechaIncidenciaDto> toApiFechaIncidenciaList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalFechaIncidenciaDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalCondicionesDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalCondicionesDto> toApiCondicionesList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalCondicionesDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalCarenciaDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalCarenciaDto> toApiCarenciaList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalCarenciaDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalExternaDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalExternaDto> toApiExternosList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalExternaDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalComisionManualDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalComisionManualDto> toApiComisionManualList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalComisionManualDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalLocalizacionDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalLocalizacionDto> toApiLocalizacionList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalLocalizacionDto> src);

  /**
   * Maps a list of client model {@code IdPersonaLocalDto} to API DTOs.
   *
   * @param src the client model list.
   * @return the API list.
   */
  List<IdPersonaLocalDto> toApiPersonaLocalList(
      List<com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.IdPersonaLocalDto> src);

}
