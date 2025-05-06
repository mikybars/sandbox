package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionCadenaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaAgrupacionCadenaMapperDecorator extends TareaAgrupacionCadenaMapper {

  @Autowired
  private TareaAgrupacionCadenaMapper delegate;

  @Override
  public List<TareaAgrupacionCadena> getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(
      List<AgrupOnlineResultItemDto> src, TareaDto tarea) {
    final List<TareaAgrupacionCadena> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> {
        final TareaAgrupacionCadena agrupacion = this.delegate.getAgrupOnlineResultItemDtoToTareaAgrupacionCadena(x,
            tarea);
        final boolean multiple = src.stream()
            .filter(y -> y.getIdOrigen().equals(x.getIdOrigen())
                && y.getIdAgrupacion().equals(x.getIdAgrupacion()))
            .count() > 1;
        agrupacion.setMultiple(multiple);
        result.add(agrupacion);
      });
    }
    return result;
  }

  @Override
  public List<TareaAgrupacionCadenaDto> getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(
      List<TareaAgrupacionCadena> src) {
    final List<TareaAgrupacionCadenaDto> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> result.add(this.delegate.getTareaAgrupacionCadenaToTareaAgrupacionCadenaDto(x)));
    }
    return result;
  }

  @Override
  public List<TareaAgrupacionCadenasDto> getTareaAgrupacionCadenaToTareaAgrupacionCadenasDto(
      List<TareaAgrupacionCadena> src) {
    final Map<Long, List<String>> cadenas = new HashMap<>();
    if (src != null) {
      src.forEach(x -> {
        if (!cadenas.containsKey(x.getIcmIdAgrupacionOnline())) {
          cadenas.put(x.getIcmIdAgrupacionOnline(), new ArrayList<>());
        }
        cadenas.get(x.getIcmIdAgrupacionOnline()).add(x.getCclIdCadena());
      });
    }

    final List<TareaAgrupacionCadenasDto> result = new ArrayList<>();
    cadenas
        .forEach((idAgrupacion, idCadenas) -> result.add(new TareaAgrupacionCadenasDto(idAgrupacion, idCadenas)));

    return result;
  }

  @Override
  public List<TareaAgrupacionCadena> getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena(
      List<AgrupacionesOnlineResponseDTO> src, TareaDto tarea) {
    final List<TareaAgrupacionCadena> result = new ArrayList<>();
    if (src != null) {
      src.forEach(x -> {
        final TareaAgrupacionCadena agrupacion = this.delegate.getAgrupacionesOnlineResponseDtoToTareaAgrupacionCadena(x,
            tarea);
        final boolean multiple = src.stream()
            .filter(y -> y.getIdOrigen().equals(x.getIdOrigen())
                && y.getIdAgrupacionOnline().equals(x.getIdAgrupacionOnline()))
            .count() > 1;
        agrupacion.setMultiple(multiple);
        result.add(agrupacion);
      });
    }
    return result;
  }

}
