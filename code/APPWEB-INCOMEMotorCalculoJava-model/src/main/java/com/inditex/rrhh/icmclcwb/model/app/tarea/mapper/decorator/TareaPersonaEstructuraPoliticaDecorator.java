package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoUnidadTiempoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoPoliticaService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoUnidadTiempoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraPoliticaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaCondicionesPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.ListaValoresPoliticasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraPoliticaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoUnidadTiempo;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class TareaPersonaEstructuraPoliticaDecorator extends TareaPersonaEstructuraPoliticaMapper {

  @Autowired
  private TareaPersonaEstructuraPoliticaMapper delegate;

  @Autowired
  private TipoPoliticaService tipoPoliticaService;

  @Autowired
  private TipoUnidadTiempoService tipoUnidadTiempoService;

  @Override
  public TareaPersonaEstructuraPolitica tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
      TareaPersonaEstructuraPoliticaDto src) {
    TareaPersonaEstructuraPolitica result = delegate
        .tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(src);
    TipoPoliticaDto politica = tipoPoliticaService.findByIdMeta4(src.getIdTipoPolitica());
    result.setTipoPolitica(new TipoPolitica());
    result.getTipoPolitica().setId(politica.getId());
    return result;
  }

  @Override
  public List<TareaPersonaEstructuraPolitica> tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(
      List<TareaPersonaEstructuraPoliticaDto> src) {
    List<TareaPersonaEstructuraPolitica> result = new ArrayList<>();
    src.forEach(x -> result.add(tareaPersonaEstructuraPoliticaDtoToTareaPersonaEstructuraPolitica(x)));
    return result;
  }

  @Override
  public TareaPersonaEstructuraPoliticaDto tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
      TareaPersonaEstructuraPolitica src) {
    TareaPersonaEstructuraPoliticaDto result = delegate
        .tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(src);
    TipoPoliticaDto politica = tipoPoliticaService.findById(src.getTipoPolitica().getId());
    result.setIdTipoPolitica(politica.getIcmIdTpPolitica());
    return result;
  }

  @Override
  public List<TareaPersonaEstructuraPoliticaDto> tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(
      List<TareaPersonaEstructuraPolitica> src) {
    List<TareaPersonaEstructuraPoliticaDto> result = new ArrayList<>();
    src.forEach(x -> result.add(tareaPersonaEstructuraPoliticaToTareaPersonaEstructuraPoliticaDto(x)));
    return result;
  }

  @Override
  public TareaPersonaEstructuraPolitica comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
      ComisionEmpleadoResultItemDto src, TareaDto tarea) {
    TareaPersonaEstructuraPolitica result = delegate
        .comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(src, tarea);
    TipoPoliticaDto politica = tipoPoliticaService.findByIdMeta4(src.getIdTipoPolitica());
    result.setTipoPolitica(new TipoPolitica());
    result.getTipoPolitica().setId(politica.getId());
    result.setExcluidoDenominador(Meta4Constants.TRUE.equals(src.getExcDenominador()));
    return result;
  }

  @Override
  public List<TareaPersonaEstructuraPolitica> comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(
      List<ComisionEmpleadoResultItemDto> src, TareaDto tarea) {
    List<TareaPersonaEstructuraPolitica> result = new ArrayList<>();
    src.forEach(x -> {
      // Si el tipo es EXCLUIDO DENOMINADOR, solo se guardan aquellos que tengan
      // flag a TRUE (los de flag a FALSE es ruido desde el punto de vista del proceso de cálculo)
      if (!TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getIdMeta4().equals(x.getIdTipoPolitica())
          ||
          Meta4Constants.TRUE.equals(x.getExcDenominador())) {
        result.add(comisionEmpleadoResultItemDtoToTareaPersonaEstructuraPolitica(x, tarea));
      }
    });
    return result;
  }

  @Override
  public List<TareaPersonaEstructuraPolitica> estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
      List<EstructurasPolResultItemDto> src, TareaDto tarea) {
    List<TareaPersonaEstructuraPolitica> result = new ArrayList<>();
    src.forEach(x -> x.getIcmListaCondicionesPolitica().forEach(y -> {
      if (!TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getIdMeta4().equals(y.getIdTipoPolitica())
          || y.getExcDenominador().equals(Meta4Constants.TRUE)) {
        y.getIcmListaValoresPoliticas()
            .forEach(z -> result
                .add(estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(x, y, z, tarea)));
        if (TipoPoliticaEnum.EXCLUIDO_DENOMINADOR.getIdMeta4().equals(y.getIdTipoPolitica())
            || TipoPoliticaEnum.MAXIMO_GARANTIZADO.getIdMeta4().equals(y.getIdTipoPolitica())
            || TipoPoliticaEnum.MINIMO_GARANTIZADO.getIdMeta4().equals(y.getIdTipoPolitica())
            || TipoPoliticaEnum.HORAS_FIJAS.getIdMeta4().equals(y.getIdTipoPolitica())) {
          result.add(estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(x, y, null, tarea));
        }
      }
    }));
    return result;
  }

  @Override
  public TareaPersonaEstructuraPolitica estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(
      EstructurasPolResultItemDto src, ListaCondicionesPoliticasResultItemDto condiciones,
      ListaValoresPoliticasResultItemDto valores, TareaDto tarea) {
    TareaPersonaEstructuraPolitica result = delegate
        .estructurasPolResultItemDtoToTareaPersonaEstructuraPolitica(src, tarea);
    TipoPoliticaDto politica = tipoPoliticaService.findByIdMeta4(condiciones.getIdTipoPolitica());
    result.setTipoPolitica(new TipoPolitica());
    result.getTipoPolitica().setId(politica.getId());
    result.setExcluidoDenominador(Meta4Constants.TRUE.equals(condiciones.getExcDenominador()));
    if (TipoPoliticaEnum.MAXIMO_GARANTIZADO.getIdMeta4().equals(condiciones.getIdTipoPolitica())) {
      result.setImporte(new BigDecimal(condiciones.getImporteMax()));
    }
    if (TipoPoliticaEnum.MINIMO_GARANTIZADO.getIdMeta4().equals(condiciones.getIdTipoPolitica())) {
      result.setImporte(new BigDecimal(condiciones.getImporteMin()));
    }
    if (!TipoPoliticaEnum.MINIMO_GARANTIZADO.getIdMeta4().equals(condiciones.getIdTipoPolitica())
        && !TipoPoliticaEnum.MAXIMO_GARANTIZADO.getIdMeta4().equals(condiciones.getIdTipoPolitica())) {
      result.setImporte(new BigDecimal(0));
    }
    result.setIdMotivoBaja(
        StringUtils.isNotEmpty(condiciones.getIdMotivoBaja()) ? condiciones.getIdMotivoBaja() : "0");
    result.setNumMesesCalcMedia(
        StringUtils.isNotEmpty(condiciones.getNumMesesCalcMedia()) ? condiciones.getNumMesesCalcMedia() : "0");
    result.setNumHoras(StringUtils.isNotEmpty(condiciones.getNumHoras()) ? condiciones.getNumHoras() : "0");
    result.setTipoUnidadTiempo(new TipoUnidadTiempo());
    if (valores != null && StringUtils.isNotEmpty(valores.getIdUnidadTiempo())) {
      TipoUnidadTiempoDto unidadTiempo = tipoUnidadTiempoService
          .findByIcmIdUnidadTiempo(valores.getIdUnidadTiempo());
      result.getTipoUnidadTiempo()
          .setId(unidadTiempo.getId());
    } else {
      result.getTipoUnidadTiempo().setId(TipoUnidadTiempoEnum.NINGUNO.getId());
    }
    result.setNumeroUnidades(valores != null && StringUtils.isNotEmpty(valores.getNumeroUnidades())
        ? valores.getNumeroUnidades()
        : "0");
    result.setValor(valores != null && StringUtils.isNotEmpty(valores.getValor())
        ? new BigDecimal(valores.getValor())
        : new BigDecimal(0));
    result.setTramo(valores != null && StringUtils.isNotEmpty(valores.getTramo())
        ? Integer.valueOf(valores.getTramo())
        : 0);
    return result;
  }

}
