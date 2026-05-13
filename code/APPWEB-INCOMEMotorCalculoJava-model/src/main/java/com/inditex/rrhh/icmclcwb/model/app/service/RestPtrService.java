package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.Collections;

import com.inditex.rrhh.icmclccore.comisfacade.rest.client.api.PresenciasApi;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.BuscarPresenciasDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.PresenciaOrigenDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaAmbitoDto;
import com.inditex.rrhh.icmclccore.comisfacade.rest.client.model.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.annotation.NuevoMotor;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * PTR implementation backed by Facade COMIS/PTR REST APIs.
 *
 * <p>Active only when {@code app.motor-calculo.nuevo.enabled=true}.
 */
@Service
@Validated
@NuevoMotor
@RequiredArgsConstructor
public class RestPtrService implements PtrService {

  @Qualifier("presenciasComisApiClient")
  private final PresenciasApi presenciasApi;

  private final Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  /**
   * Retrieves PTR attendance source data for the current task and scope.
   *
   * @param runTareaDto task execution payload.
   * @param tareaAmbito task scope payload.
   * @return attendance hours grouped by section.
   */
  @Override
  public com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
      @Valid final com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto tareaAmbito) {
    final BuscarPresenciasDto request = this.buildBuscarPresenciasRequest(runTareaDto.getTarea(), tareaAmbito, false);
    final PresenciaOrigenDto response = this.presenciasApi.buscarPresencias(request, null);
    return this.mapPresenciaOrigen(response);
  }

  /**
   * Retrieves PTR ES attendance source data for the current task and scope.
   *
   * @param runTareaDto task execution payload.
   * @param tareaAmbito task scope payload.
   * @return attendance hours grouped by section.
   */
  @Override
  public com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto findPresenciasOrigenAndFechaEs(@Valid final RunTareaDto runTareaDto,
      @Valid final com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto tareaAmbito) {
    final BuscarPresenciasDto request = this.buildBuscarPresenciasRequest(runTareaDto.getTarea(), tareaAmbito, true);
    final PresenciaOrigenDto response = this.presenciasApi.buscarPresencias(request, null);
    return this.mapPresenciaOrigen(response);
  }

  private @Nullable Integer getIdCatalogo(com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto tareaDto,
      com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto tareaAmbito) {
    Integer idCatalogo = null;
    if (AppConstants.ID_ORIGEN_SPAIN.equals(tareaAmbito.getCclIdOrigen())) {
      final CatalogoResponseDto response = this.meta4IcmWsCalcIncomeService
          .getCatalogo(CatalogoRequestDto
              .builder()
              .cclIdOrigen(tareaAmbito.getCclIdOrigen())
              .items(Collections.singletonList(CatalogoRequestItemDto
                  .builder()
                  .stdIdLegEnt(tareaDto.getStdIdLegEnt())
                  .build()))
              .build());
      if ((response != null)
          && CollectionUtils.isNotEmpty(response.getItems())
          && StringUtils.isNotBlank(response.getItems().get(0).getIdCatalogo())) {
        idCatalogo = Integer.parseInt(response.getItems().get(0).getIdCatalogo());
      } else {
        throw new IcmclcwbException("No se han podido recuperar tipos de hora");
      }
    }
    return idCatalogo;
  }

  private BuscarPresenciasDto buildBuscarPresenciasRequest(final com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto tarea,
      final com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto ambito, final boolean includeIdCatalogo) {
    return new BuscarPresenciasDto()
        .tarea(new TareaDto()
            .fechaInicioPeriodo(tarea.getFechaInicioPeriodo())
            .fechaFinPeriodo(tarea.getFechaFinPeriodo()))
        .ambito(new TareaAmbitoDto()
            .cclIdOrigen(ambito.getCclIdOrigen()))
        .idCatalogoAplicacion(includeIdCatalogo ? getIdCatalogo(tarea, ambito) : null);
  }

  private com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto mapPresenciaOrigen(final PresenciaOrigenDto presenciaOrigenDTO) {
    if (presenciaOrigenDTO == null) {
      return com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto.builder().build();
    }
    return com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto.builder()
        .horasSeccion1(presenciaOrigenDTO.getHorasSeccion1())
        .horasSeccion2(presenciaOrigenDTO.getHorasSeccion2())
        .horasSeccion3(presenciaOrigenDTO.getHorasSeccion3())
        .horasSeccion4(presenciaOrigenDTO.getHorasSeccion4())
        .build();
  }

}
