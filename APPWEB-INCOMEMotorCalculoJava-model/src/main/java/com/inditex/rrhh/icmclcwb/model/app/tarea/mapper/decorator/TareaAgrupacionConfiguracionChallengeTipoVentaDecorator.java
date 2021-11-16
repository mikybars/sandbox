package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionChallengeTipoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAgrupacionConfiguracionChallengeTipoVentaDecorator
    extends TareaAgrupacionConfiguracionChallengeTipoVentaMapper {

  @Autowired
  private TareaAgrupacionConfiguracionChallengeTipoVentaMapper delegate;

  @Autowired
  private TipoVentaConceptoChallengeService tipoVentaConceptoChallengeService;

  @Override
  public List<TareaAgrupacionConfiguracionChallengeTipoVenta> confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(
      List<ConfChTpVentaResultItemDto> src, TareaDto tarea) {
    List<TareaAgrupacionConfiguracionChallengeTipoVenta> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> {
        TareaAgrupacionConfiguracionChallengeTipoVenta config = delegate
            .confChTpVentaResultItemDtoToTareaAgrupacionConfiguracionChallengeTipoVenta(x, tarea);
        TipoVentaConceptoChallengeDto concepto = tipoVentaConceptoChallengeService
            .findByIcmIdConceptoVenta(x.getIdConceptoVenta());
        config.setTipoVentaConceptoChallenge(TipoVentaConceptoChallenge.builder().id(concepto.getId()).build());
        result.add(config);
      });
    }
    return result;
  }

}
