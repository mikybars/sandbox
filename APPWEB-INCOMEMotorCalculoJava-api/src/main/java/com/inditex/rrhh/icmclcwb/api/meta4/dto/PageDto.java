package com.inditex.rrhh.icmclcwb.api.meta4.dto;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.meta4.exception.Meta4IcmclcwbException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.math.NumberUtils;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageDto implements Serializable {

  private static final long serialVersionUID = 1951305116634110315L;

  private String tipoOrden;

  private String campoOrden;

  private String idBusqueda;

  @NonNull
  private Integer numeroPagina;

  private Integer numeroTotalPaginas;

  @NonNull
  private Integer numeroRegistrosPagina;

  private Integer numeroTotalResultados;

  public boolean hasNext() {
    boolean result = false;
    // Primera carga, en las iteraciones cuando no hay registros, llega
    // {numeroPagina: 0, numeroTotalPaginas: 0}
    if (numeroPagina != null
        && ((numeroTotalPaginas == null && Integer.compare(numeroPagina, NumberUtils.INTEGER_ZERO) == 0)
            || (numeroTotalPaginas != null && Integer.compare(numeroPagina, numeroTotalPaginas) < 0))) {
      result = true;
    }
    return result;
  }

  public PageDto next() {
    if (hasNext()) {
      setNumeroPagina(Integer.valueOf(numeroPagina.intValue() + 1));
    } else {
      throw new Meta4IcmclcwbException("Error en la paginacion");
    }
    return this;
  }

}
