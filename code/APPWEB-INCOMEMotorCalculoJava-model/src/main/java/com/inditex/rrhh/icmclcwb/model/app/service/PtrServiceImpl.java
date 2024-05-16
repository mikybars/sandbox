package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.PtrService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustom;

import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PtrServiceImpl implements PtrService {

  @Autowired
  private PtrRepositoryCustom ptrRepositoryCustom;

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    return this.ptrRepositoryCustom
        .findPresenciasOrigenAndFecha(runTareaDto.getTarea(), tareaAmbito);
  }

  @Override
  public PresenciaOrigenDto findPresenciasOrigenAndFechaEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito) {
    Integer idCatalogo = null;
    if (AppConstants.ID_ORIGEN_SPAIN.equals(tareaAmbito.getCclIdOrigen())) {
      final CatalogoResponseDto response = this.meta4IcmWsCalcIncomeService
          .getCatalogo(CatalogoRequestDto
              .builder()
              .cclIdOrigen(tareaAmbito.getCclIdOrigen())
              .items(Arrays
                  .asList(CatalogoRequestItemDto
                      .builder()
                      .stdIdLegEnt(runTareaDto.getTarea().getStdIdLegEnt())
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
    return this.ptrRepositoryCustom
        .findPresenciasOrigenAndFechaEs(runTareaDto.getTarea(), tareaAmbito, idCatalogo);
  }

}
