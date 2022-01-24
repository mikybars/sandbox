package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConcepto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAgrupacionAgrupacionConfiguracionDecorator extends TareaAgrupacionConfiguracionMapper {

  @Autowired
  private TareaAgrupacionConfiguracionMapper delegate;

  @Autowired
  private TipoVentaConceptoService tipoVentaConceptoService;

  @Override
  public TareaAgrupacionConfiguracion getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
      ConfiguracionVentaOnlineResultItemDto src, TareaDto tareaDto) {
    TipoVentaConceptoDto concepto = tipoVentaConceptoService.findByIdMeta4(src.getIdConcepto());
    TareaAgrupacionConfiguracion result = delegate
        .getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(src, tareaDto);
    result.setTipoVentaConcepto(TipoVentaConcepto.builder().id(concepto.getId()).build());
    return result;
  }

  @Override
  public List<TareaAgrupacionConfiguracion> getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(
      List<ConfiguracionVentaOnlineResultItemDto> src, TareaDto tareaDto) {
    List<TareaAgrupacionConfiguracion> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> result
          .add(getConfiguracionVentaOnlineResponseItemDtoToTareaAgrupacionConfiguracion(x, tareaDto)));
    }
    return result;
  }

  @Override
  public TareaAgrupacionConfiguracionDto getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
      TareaAgrupacionConfiguracion src) {
    TipoVentaConceptoDto concepto = tipoVentaConceptoService.findById(src.getTipoVentaConcepto().getId());
    TareaAgrupacionConfiguracionDto result = delegate
        .getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(src);
    result.setTipoVentaConcepto(concepto);
    return result;
  }

  @Override
  public List<TareaAgrupacionConfiguracionDto> getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(
      List<TareaAgrupacionConfiguracion> src) {
    List<TareaAgrupacionConfiguracionDto> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> result.add(getTareaAgrupacionConfiguracionToTareaAgrupacionConfiguracionDto(x)));
    }
    return result;
  }

}
