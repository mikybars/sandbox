package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionConfiguracionChallengeTipoVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionChallengeTipoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl
    implements TareaAgrupacionConfiguracionChallengeTipoVentaService {

  @Autowired
  private TareaAgrupacionConfiguracionChallengeTipoVentaMapper tareaAgrupacionConfiguracionChallengeTipoVentaMapper;

  @Autowired
  private TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom;

  @Override
  public void save(@Valid @NotNull @NotEmpty final List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> src,
      @Valid @NotNull final TareaDto tarea) {
    tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom.save(
        tareaAgrupacionConfiguracionChallengeTipoVentaMapper
            .tareaAgrupacionConfiguracionChallengeTipoVentaDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
                src));
  }

  @Override
  public void saveConfChTpVentaResultItemDto(@Valid @NotNull @NotEmpty final List<ConfChTpVentaResultItemDto> src,
      @Valid @NotNull final TareaDto tarea) {
    tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom.save(
        tareaAgrupacionConfiguracionChallengeTipoVentaMapper
            .confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(src, tarea));
  }

}
