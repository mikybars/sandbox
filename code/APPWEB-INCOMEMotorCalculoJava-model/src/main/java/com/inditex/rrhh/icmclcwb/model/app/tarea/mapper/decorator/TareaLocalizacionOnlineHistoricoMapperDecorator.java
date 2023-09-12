package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.LocalizacionOnlineDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiendasonline.dto.TiendaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionOnlineHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOnlineHistorico;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionOnlineHistoricoMapperDecorator extends TareaLocalizacionOnlineHistoricoMapper {

  @Autowired
  TareaLocalizacionOnlineHistoricoMapper delegate;

  @Override
  public List<TareaLocalizacionOnlineHistorico> getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(
      List<TiendaOnlineResultItemDto> src, TareaDto tarea) {
    List<TareaLocalizacionOnlineHistorico> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> result.add(delegate.getTiendaOnlineResultItemDtoToTareaTiendaOnlineHistorico(x, tarea)));
    }
    return result;
  }

  @Override
  public List<LocalizacionOnlineDto> getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(
      List<TareaLocalizacionOnlineHistorico> src) {
    List<LocalizacionOnlineDto> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> result.add(delegate.getTareaTiendaOnlineHistoricoToLocalizacionOnlineDto(x)));
    }
    return result;
  }

}
