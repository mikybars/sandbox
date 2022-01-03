package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.PtrSeccionPresenciasGenericType;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaLocalizacionPersonaPresenciaDecorator
    extends TareaLocalizacionPersonaPresenciaMapper {

  @Autowired
  private TareaLocalizacionPersonaPresenciaMapper delegate;

  @Override
  public List<TareaLocalizacionPersonaPresencia> genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(
      final List<GenericEmpleadoResultItemDto> src, final TareaDto tareaDto) {
    final List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(src)) {
      src.forEach(item -> {
        if (AppConstants.getSECCIONES_STRING().contains(item.getIdSeccion())) {
          result.add(
              this.delegate.genericEmpleadoResultItemDtoToTareaLocalizacionPersonaPresencia(item,
                  tareaDto));
        }
      });
    }
    return result;
  }

  @Override
  public List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
      final List<PtrPresenciaDetalleResultItemDto> src, final TareaDto tareaDto, final Integer idTipoDato) {
    final List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
    src.forEach(x -> result
        .addAll(this.presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(x.getListaSeccion(), x,
            tareaDto, idTipoDato)));
    return result;
  }

  private List<TareaLocalizacionPersonaPresencia> presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(
      final List<PtrSeccionPresenciasGenericType> listaSeccion,
      final PtrPresenciaDetalleResultItemDto presenciaTotalizado,
      final TareaDto tareaDto,
      final Integer idTipoDato) {
    final List<TareaLocalizacionPersonaPresencia> result = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(listaSeccion)) {
      listaSeccion.forEach(x -> {
        final TareaLocalizacionPersonaPresencia presencia = this.delegate
            .presenciasDetalleResponseDtoToTareaLocalizacionPersonaPresencia(presenciaTotalizado, tareaDto,
                idTipoDato);
        presencia.setCclIdSeccion(x.getSeccion().toString());
        presencia.setMinutos(x.getMinutos());
        presencia.setTipoDato(new TipoDato());
        presencia.getTipoDato()
            .setId(idTipoDato);
        result.add(presencia);
      });

    }
    return result;
  }

}
